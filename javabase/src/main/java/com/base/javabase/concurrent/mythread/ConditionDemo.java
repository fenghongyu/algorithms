package com.base.javabase.concurrent.mythread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/9 17:07
 */
public class ConditionDemo {

    final static ReentrantLock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {

        ConditionThread t = new ConditionThread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

    static class ConditionThread implements Runnable{
        int i = 1;
        @Override
        public void run() {
            while (true){
                lock.lock();
//                condition.signal();
                try {
                    /*使其休眠100毫秒，放大线程差异*/
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    i++;

                } catch (Exception e){

                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
