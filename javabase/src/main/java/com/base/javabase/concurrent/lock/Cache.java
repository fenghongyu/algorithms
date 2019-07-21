package com.base.javabase.concurrent.lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();
    // 获取一个key对应的value
    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }
    // 设置key对应的value，并返回旧的value
    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }
    // 清空所有的内容
    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
        Collections.sort(new ArrayList<Integer>());
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map.get(null));
        map.put("1", null);
        map.put(null, "1");
        map.put("2", null);
        System.out.println(map.get(null));
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
    }


}