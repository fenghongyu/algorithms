package com.base.javabase.concurrent.synchronizeddemo;

/**
 * Created on 2019-09-20
 *
 * @author fenghongyu
 */
public class SynchronizedMainTest {
    public static void main(String[] args) {

        ErrorResultThread resultThread = new ErrorResultThread();

        Thread t1 = new Thread(resultThread);
        Thread t2 = new Thread(resultThread);

        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
            //t1 ， t2线程存活，主线程阻塞。
        }
        System.out.println("-------thread finish");
    }
}



//    SynchronizedObjectBlock synchronizedObjectBlock = new SynchronizedObjectBlock();
//        System.out.println("-----锁的runable 对象hashcode：" + synchronizedObjectBlock.hashCode());
//    Thread t1 = new Thread(synchronizedObjectBlock);
//    Thread t2 = new Thread(synchronizedObjectBlock);
//
//        t1.start();
//        t2.start();
//
//        while (t1.isAlive() || t2.isAlive()) {
//        //t1 ， t2线程存活，主线程阻塞。
//    }
