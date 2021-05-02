package com.metao.dp.saga.choreography;

public class SagaApplication {

  /**
   * main method.
   */
  public static void main(String[] args) {
    var sd = serviceDiscovery();
    var service = sd.findAny();
    var goodOrderSaga = service.execute(newSaga("good_order"));
    var badOrderSaga = service.execute(newSaga("bad_order"));
    System.out.printf("orders: goodOrder is %s, badOrder is %s",
            goodOrderSaga.getResult(), badOrderSaga.getResult());
  }


  private static Saga newSaga(Object value) {
    return Saga
            .create()
            .chapter("init an order").setInValue(value)
            .chapter("booking a Fly")
            .chapter("booking a Hotel")
            .chapter("withdrawing Money");
  }

  private static ServiceDiscoveryService serviceDiscovery() {
    var sd = new ServiceDiscoveryService();
    return sd
            .discover(new OrderService(sd))
            .discover(new FlyBookingService(sd))
            .discover(new WithdrawMoneyService(sd))
            .discover(new HotelBookingService(sd));
  }
}
