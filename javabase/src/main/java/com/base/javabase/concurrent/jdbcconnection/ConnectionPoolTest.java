package com.base.javabase.concurrent.jdbcconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2019-05-31
 * @author fenghongyu
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 1000;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for(int i=0;i<threadCount;i++) {
            Thread thread = new Thread(new ConnetionRunner(got, notGot, count), "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("-----------got" + got);
        System.out.println("-----------notGot" + notGot);
    }

    static class ConnetionRunner implements Runnable{
        AtomicInteger got;
        AtomicInteger notGot;
        int count;

        public ConnetionRunner(AtomicInteger got, AtomicInteger notGot, int count) {
            this.got = got;
            this.notGot = notGot;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0){
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}