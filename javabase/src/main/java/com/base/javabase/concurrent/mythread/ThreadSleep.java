package com.base.javabase.concurrent.mythread;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/9 15:40
 */
public class ThreadSleep {


    public static void main(String[] args) {
        MyThreadSleep sleep = new MyThreadSleep();
        Thread thread = new Thread(sleep);
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                thread.interrupt();
            }
        }).start();

    }

    static class MyThreadSleep implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("*****");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
