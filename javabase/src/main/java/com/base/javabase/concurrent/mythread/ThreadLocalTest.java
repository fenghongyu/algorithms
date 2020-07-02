package com.base.javabase.concurrent.mythread;

import java.util.ArrayList;
import java.util.List;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/5/28 11:35
 */
public class ThreadLocalTest {
    private List<String> messages = new ArrayList<>();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest.add("一枝花算不算浪漫");
                System.out.println(holder.get().messages);
//                ThreadLocalTest.clear();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest.add("sad发生地方");
                System.out.println(holder.get().messages);
//                ThreadLocalTest.clear();
            }
        }).start();
    }
}
