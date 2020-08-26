package com.metao.dp.ami;

import java.util.concurrent.ExecutionException;

public interface AsyncResult<T> {

    public boolean isCompleted();

    public T getValue() throws ExecutionException;

    public void await() throws InterruptedException;
}
