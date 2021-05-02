package com.metao.dp.saga.orchestration;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class StringObserverHandler implements Subject<String> {

    private final Queue<Observer<String>> observers = new ConcurrentLinkedDeque<>();

    @Override
    public void registerObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String object) {
        observers.parallelStream().forEach((observer) -> observer.onUpdate(object));
    }
}
