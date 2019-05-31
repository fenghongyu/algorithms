package com.base.javabase.concurrent.jdbcconnection;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created on 2019-05-31
 * @author fenghongyu
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if(initialSize > 0) {
            for(int i=0;i<initialSize;i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    /**
     * 释放资源链接
     */
    public void releaseConnection(Connection connection) {
        if(connection != null) {
            synchronized (pool) {
                //连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 获取链接
     */
    public Connection fetchConnection (long mils) throws InterruptedException {
        synchronized (pool) {
            if (mils <= 0) {
                //完全超时
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mils;
                long remaining = mils;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
