package com.base.javabase.concurrent.mythread;

import lombok.SneakyThrows;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/9 15:57
 */
public class NotifyDemo  {
    public static void main(String[] args) throws InterruptedException {
//        Print100 p = new Print100();
//        Thread thread1  = new Thread(p);
//        Thread thread2  = new Thread(p);
//
//        thread1.setName("奇数：");
//        thread2.setName("偶数：");
//
//        thread1.start();
//        thread2.start();


        Print100 t = new Print100();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

    static class Print100 implements Runnable{
        int i= 1;
        @SneakyThrows
        @Override
        public void run() {

            while (true){
                synchronized (this){
                    notify();
                    try {
                        /*使其休眠100毫秒，放大线程差异*/
                        Thread.currentThread();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    i++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
