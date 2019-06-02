package com.base.javabase.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReenReadWriteDemo {
    private Map<String, String> hashMap = new HashMap<>();
    private ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
    private Lock rl = rrwl.readLock();
    private Lock wl = rrwl.writeLock();

    public String getObject(String key) {
        rl.lock();
        try {
            return hashMap.get(key);
        } finally {
            rl.unlock();
        }
    }

    public Object setObject(String key, String value) {
        wl.lock();

        try {
            return hashMap.put(key, value);
        } finally {
            wl.unlock();
        }
    }

    public void clear() {
        wl.lock();
        try {
            hashMap.clear();
        } finally {
            wl.unlock();
        }
    }


}
