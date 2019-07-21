package com.base.javabase.concurrent.mythread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future future = newCachedThreadPool.submit(new MyCallable());
        if(!future.isDone()) {
            System.out.println("please wait");
        }
        try {
            System.out.println("value is " + future.get());
        } catch (Exception e) {

        } finally {
            newCachedThreadPool.shutdown();
        }

    }
}
