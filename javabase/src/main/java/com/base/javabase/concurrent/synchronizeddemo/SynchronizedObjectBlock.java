package com.base.javabase.concurrent.synchronizeddemo;

/**
 * Created on 2019-09-20
 *Synchronized 对象锁
 * @author fenghongyu
 */
public class SynchronizedObjectBlock implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            System.out.println(this.hashCode());
            System.out.println("当前线程启动："+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程结束："+Thread.currentThread().getName());
        }
    }
}
