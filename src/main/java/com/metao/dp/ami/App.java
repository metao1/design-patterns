package com.metao.dp.ami;

import java.util.Random;
import java.util.concurrent.Callable;

public class App {

    public static void main(String[] args) throws Exception {
        var executor = new ThreadAsyncExecutor();

        var stringAsyncResult1 = executor.startProcess(call("10"));
        System.out.println("runner 1");
        var stringAsyncResult2 = executor.startProcess(call("20"));
        System.out.println("runner 2");
        var stringAsyncResult3 = executor.startProcess(call("30"));
        System.out.println("runner 3");
        var stringAsyncResult4 = executor.startProcess(call("50"));
        System.out.println("runner 4");

        var integerAsyncResult1 = executor.startProcess(call(40), callback("Callback result 1"));

        var integerAsyncResult2 = executor.startProcess(call(50), callback("Callback result 2"));

        Thread.sleep(300);

        String result1 = executor.endProcess(stringAsyncResult1);
        String result2 = executor.endProcess(stringAsyncResult2);
        String result3 = executor.endProcess(stringAsyncResult3);

        integerAsyncResult1.await();

        integerAsyncResult2.await();

        System.out.printf("task finished with %s%n", result1);
        System.out.printf("task finished with %s%n", result2);
        System.out.printf("task finished with %s%n", result3);

    }

    private static <T> AsyncCallback<T> callback(String name) {
        return (value, ex) -> {
            if (ex.isPresent()) {
                System.out.printf("task failed with %s%n", ex.map(Exception::getMessage).orElse(""));
            } else {
                System.out.printf("name=%s, value=%s %n", name, value);
            }
        };

    }

    private static <T> Callable<T> call(T value) {
        return () -> {
            Thread.sleep(new Random().nextInt(1000));//randomly  delay
            System.out.printf("task completed with %s%n", value);
            return value;
        };
    }
}
