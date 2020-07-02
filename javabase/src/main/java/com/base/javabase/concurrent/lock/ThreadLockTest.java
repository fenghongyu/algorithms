package com.base.javabase.concurrent.lock;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/5/28 11:21
 */

public class ThreadLockTest implements Runnable {

    private String string;
    private Object prev;
    private Object next;

    public ThreadLockTest(Object prev, Object next, String string) {
        // TODO Auto-generated constructor stub
        this.string = string;
        this.prev = prev;
        this.next = next;
    }

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        ThreadLockTest a = new ThreadLockTest(o1, o2, "A");
        ThreadLockTest b = new ThreadLockTest(o2, o1, "B");

        new Thread(a).start();
        Thread.sleep(100);
        new Thread(b).start();
        Thread.sleep(100);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        int n = 10;
        while (n > 0) {
            synchronized(prev) {
                System.out.println("+++++++++++++");
                synchronized(next) {
                    System.out.println(string + " ");
                    System.out.println(n);
                    System.out.println("------------");
                    next.notify();      //notify在同步块完成后释放锁
                    n--;

                    try {
                        prev.wait(10);
                        //不是用wait()，是因为线程虽然能释放prev锁，但会一直休眠，而占用next锁。
                        //wait会在10毫秒后立即释放锁。
                        //造成死锁的原因即是wait释放的锁被立即拿到，但是同步块未完成，notify释放的锁还未释放 。
                        //使用wait(1)可以先跑A线程，再跑B线程，但这种方式可能A线程都跑不完，B线程可能抢到锁从而造成死锁。
                        //B线程抢到锁的可能性较小？
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

