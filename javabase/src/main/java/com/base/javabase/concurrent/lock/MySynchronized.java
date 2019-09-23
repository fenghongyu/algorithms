package com.base.javabase.concurrent.lock;

/**
 * Created on 2019-09-18
 *
 * @author fenghongyu
 */
public class MySynchronized {

    public synchronized void getOne() {
        getTwo();
        System.out.println("one");
    }

    public synchronized void getTwo() {
        System.out.println("two");
    }
}
