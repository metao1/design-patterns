package com.metao.dp.saga.orchestration;

public class OrderService extends Service<String> {
  @Override
  public String getName() {
    return "init an order";
  }
}
