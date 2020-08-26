package com.metao.dp.saga.orchestration;

import com.metao.dp.saga.orchestration.Saga.Result;

import static com.metao.dp.saga.orchestration.Saga.Result.*;

public class SagaOrchestrator {
  private final Saga saga;
  private final ServiceDiscoveryService sd;
  private final CurrentState state;


  /**
   * Create a new service to orchetrate sagas.
   *
   * @param saga saga to process
   * @param sd   service discovery @see {@link ServiceDiscoveryService}
   */
  public SagaOrchestrator(Saga saga, ServiceDiscoveryService sd) {
    this.saga = saga;
    this.sd = sd;
    this.state = new CurrentState();
  }

  /**
   * pipeline to execute saga process/story.
   *
   * @param value incoming value
   * @param <K>   type for incoming value
   * @return result @see {@link Result}
   */
  public <K> Result execute(K value) {
    state.cleanUp();
    System.out.println(" The new saga is about to start");
    var result = FINISHED;
    K tempVal = value;

    while (true) {
      var next = state.current();
      var ch = saga.get(next);
      var srvOpt = sd.find(ch.name);

      if (srvOpt.isEmpty()) {
        state.directionToBack();
        state.back();
        continue;
      }

      var srv = srvOpt.get();

      if (state.isForward()) {
        var processRes = srv.process(tempVal);
        if (processRes.isSuccess()) {
          next = state.forward();
          tempVal = (K) processRes.getValue();
        } else {
          state.directionToBack();
        }
      } else {
        var rlRes = srv.rollback(tempVal);
        if (rlRes.isSuccess()) {
          next = state.back();
          tempVal = (K) rlRes.getValue();
        } else {
          result = CRASHED;
          next = state.back();
        }
      }


      if (!saga.isPresent(next)) {
        return state.isForward() ? FINISHED : result == CRASHED ? CRASHED : ROLLBACK;
      }
    }

  }


  private static class CurrentState {
    int currentNumber;
    boolean isForward;

    void cleanUp() {
      currentNumber = 0;
      isForward = true;
    }

    CurrentState() {
      this.currentNumber = 0;
      this.isForward = true;
    }


    boolean isForward() {
      return isForward;
    }

    void directionToBack() {
      isForward = false;
    }

    int forward() {
      return ++currentNumber;
    }

    int back() {
      return --currentNumber;
    }

    int current() {
      return currentNumber;
    }
  }

}
