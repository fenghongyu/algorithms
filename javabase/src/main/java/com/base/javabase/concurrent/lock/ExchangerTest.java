package com.base.javabase.concurrent.lock;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2019-06-04
 * @author fenghongyu
 */
public class ExchangerTest {
    private static final Exchanger<String>exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void test(String i) {
        switch (i) {
            case "a":
                System.out.println(i);
                break;
            case "b":
                System.out.println(i);
                break;
            case "c":
                System.out.println(i);
                break;
        }
    }

//    public static int staticVar = 0;
//    public int instanceVar = 0;
//    public ExchangerTest(){
//        staticVar++;
//        instanceVar++;
//        System.out.println(“staticVar=” + staticVar + ”,instanceVar=” + instanceVar);
//    }

    public boolean getInt() {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();


        int i=1;
        return i==1?true:false;
    }

    public static void main(String[] args) {
        ExchangerTest test = new ExchangerTest();
        System.out.print(test.getInt());


//        if(System.out.printf("A") == null){
//            System.out.print("A");
//        } else {
//            System.out.print("B");
//        }

//        threadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    String A = "银行流水A"; // A录入银行流水数据
//                    exgr.exchange(A);
//                } catch (InterruptedException e) {
//                }
//            }
//        });
//        threadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    String B = "银行流水B"; // B录入银行流水数据
//                    String A = exgr.exchange("B");
//                    System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
//                } catch (InterruptedException e) {
//                }
//            }
//        });
//        threadPool.shutdown();
//
//        Future task = new FutureTask(new Callable() {
//            @Override
//            public Object call() throws Exception {
//                return 1;
//            }
//        });
//
//
//        Executors.newSingleThreadExecutor();
//        Executors.newCachedThreadPool();
//        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
//        queue.add(1);

    }
}

