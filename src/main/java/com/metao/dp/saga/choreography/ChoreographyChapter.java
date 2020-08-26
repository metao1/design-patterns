package com.metao.dp.saga.choreography;

public interface ChoreographyChapter {

  /**
   * In that case, every method is responsible to make a decision on what to do then.
   *
   * @param saga incoming saga
   * @return saga result
   */
  Saga execute(Saga saga);

  /**
   * get name method.
   *
   * @return service name.
   */
  String getName();

  /**
   * The operation executed in general case.
   *
   * @param saga incoming saga
   * @return result {@link Saga}
   */
  Saga process(Saga saga);

  /**
   * The operation executed in rollback case.
   *
   * @param saga incoming saga
   * @return result {@link Saga}
   */
  Saga rollback(Saga saga);


}
