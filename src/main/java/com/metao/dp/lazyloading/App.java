package com.metao.dp.lazyloading;

public class App {

  public static void main(String[] args) {

    // Simple lazy loader - not thread safe
    var holderNaive = new HolderNaive();
    var heavy = holderNaive.getHeavy();
    System.out.printf("heavy=%s.%n", heavy);

    // Thread safe lazy loader, but with heavy synchronization on each access
    var holderThreadSafe = new HolderThreadSafe();
    var another = holderThreadSafe.getHeavy();
    System.out.printf("another=%s.%n", another);

    // The most efficient lazy loader utilizing Java 8 features
    var java8Holder = new Java8Holder();
    var next = java8Holder.getHeavy();
    System.out.printf("next=%s.%n", next);
  }
}
