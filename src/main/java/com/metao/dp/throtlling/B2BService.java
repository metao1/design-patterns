package com.metao.dp.throtlling;

import java.util.concurrent.ThreadLocalRandom;

class B2BService {

  private final CallsCount callsCount;

  public B2BService(Throttler timer, CallsCount callsCount) {
    this.callsCount = callsCount;
    timer.start();
  }

  public int dummyCustomerApi(Tenant tenant) {
    var tenantName = tenant.getName();
    var count = callsCount.getCount(tenantName);
    System.out.printf("Counter for %s : %s%n ", tenant.getName(), count);
    if (count >= tenant.getAllowedCallsPerSecond()) {
      System.out.printf("API access per second limit reached for: %s%n", tenantName);
      return -1;
    }
    callsCount.incrementCount(tenantName);
    return getRandomCustomerId();
  }

  private int getRandomCustomerId() {
    return ThreadLocalRandom.current().nextInt(1, 10000);
  }
}
