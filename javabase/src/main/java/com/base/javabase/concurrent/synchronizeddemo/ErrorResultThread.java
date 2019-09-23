package com.base.javabase.concurrent.synchronizeddemo;

/**
 * Created on 2019-09-20
 *
 * @author fenghongyu
 */
public class ErrorResultThread implements Runnable {

    int num;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
        System.out.println("当前线程："+Thread.currentThread().getName() + "执行结果为：" + num);
    }
}
