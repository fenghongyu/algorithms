package com.base.javabase.concurrent.mythread;

import lombok.extern.slf4j.Slf4j;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/7 23:02
 */
@Slf4j
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        log.info("{} is run。",main.getName());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("{} begin run",Thread.currentThread().getName());
                try {
                    Thread.sleep(30000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("{} end run",Thread.currentThread().getName());
            }
        });
        // 开一个子线程去执行
        thread.start();
        // 当前主线程等待子线程执行完成之后再执行
        thread.join();
        log.info("{} is end", Thread.currentThread());
    }
}
