package com.base.javabase.concurrent.lock;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/5/28 11:26
 */

public class MyThreadPrinter2 implements Runnable {
    private String name;
    private Object prev;
    private Object next;

    private MyThreadPrinter2(String name, Object prev, Object next) {
        this.name = name;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public void run() {
        int count = 3;
        while (count > 0) {
            synchronized (prev) {
                synchronized (next) {
                    System.out.print(name); //打印传入当前线程的字符。
                    System.out.println();
                    count--;

                    next.notify();
                    //notify()通知wait的线程,待notify()所在的同步块运行完之后,wait所在的线程就可以继续执行，self锁在同步快运行之后释放.
                }
                try {
                    prev.wait();    //当前线程释放prev的对象锁，并休眠，直到有其他线程唤醒该线程。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //即，当pa第一次运行时，打印A，释放a锁，（并通知pb线程可以继续运行）；释放c锁，并休眠。pa线程因释放c锁而休眠，故只会被pc线程在释放c锁时唤醒。
                //pb运行时，打印B，释放b锁，通知pc线程可以继续运行了；释放a锁，并休眠。pb线程因释放a锁而休眠。
                //pc运行时，打印C，释放c锁，通知pa线程可以继续运行了；释放b锁，并休眠。pc线程因释放b锁而休眠。
                //由于每次锁住两个对象锁，故每次只可能有一个线程在运行。
            }

        }
    }



    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);
        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);
        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);


        new Thread(pa).start();
        Thread.sleep(10);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }
}

