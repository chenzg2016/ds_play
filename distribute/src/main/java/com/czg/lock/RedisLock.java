package com.czg.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 8/5/21 5:06 PM
 * @description
 */
public interface RedisLock {

    /**
     * 加锁操作
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    boolean tryLock(String key, long timeout, TimeUnit unit);

    /**
     * 解锁操作
     * @param key
     */
    void releaseLock(String key);
}
