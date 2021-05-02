package com.metao.dp.saga.orchestration;

public interface Observer<T> {
    public void onUpdate(T t);
}
