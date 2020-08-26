package com.metao.dp.lazyloading;

public class Heavy {

  public Heavy() {
    System.out.println("Creating Heavy ...");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.err.printf("Exception caught. %s.%n", e);
    }
    System.out.println("... Heavy created");
  }
}