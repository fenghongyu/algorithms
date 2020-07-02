package com.base.javabase.concurrent;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/8 22:03
 */
public class SleepUtils {

    public static void second(int seconds) {
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
