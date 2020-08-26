package com.metao.dp.saga.choreography;

public class FlyBookingService extends Service {
  public FlyBookingService(ServiceDiscoveryService service) {
    super(service);
  }

  @Override
  public String getName() {
    return "booking a Fly";
  }
}
