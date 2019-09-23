package com.base.javabase.concurrent.synchronizeddemo;

/**
 * Created on 2019-09-20
 *
 * @author fenghongyu
 */
public class ErrorResult implements Runnable {

    int num = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "的结果为：" + num);
    }
}
