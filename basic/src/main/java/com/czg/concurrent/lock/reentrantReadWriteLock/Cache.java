package com.czg.concurrent.lock.reentrantReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenzg
 * @date 8/4/21 11:38 AM
 * @description
 */
public class Cache {

    static Map<String, Object> map = new HashMap<>();

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock r = readWriteLock.readLock();

    static Lock w = readWriteLock.writeLock();

    public static final Object get(String key) {

        r.lock();

        try {
            return map.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            r.unlock();
        }
        return null;

    }

    public static final void put(String key, Object value) {
        w.lock();
        try {
            map.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            w.unlock();
        }

    }

    public static void main(String[] args) {
        System.out.println(map.put("1", "2"));
    }
}
