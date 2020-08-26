package com.metao.dp.ami;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public interface AsyncExecutor {

    public  <T>  AsyncResult<T> startProcess(Callable<T> callable);

    public <T> AsyncResult<T> startProcess(Callable<T> callable, AsyncCallback<T> ac);

    public <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException;

}
