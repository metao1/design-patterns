package com.metao.dp.saga.orchestration;

public interface Subject<T> {
    public void registerObserver(Observer<T> observer);

    public void unregisterObserver(Observer<T> observer);

    public void notifyObservers(T object);
}
