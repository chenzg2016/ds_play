package com.czg.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 8/5/21 6:00 PM
 * @description
 */
public class RedisLockImpl implements RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    private ThreadLocal<Integer> threadLocalInteger = new ThreadLocal<Integer>();

    @Override
    public boolean tryLock(String key, long timeout, TimeUnit unit){
        Boolean isLocked = false;
        if(threadLocal.get() == null){
            String uuid = UUID.randomUUID().toString();
            threadLocal.set(uuid);
            isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
            //如果获取锁失败，则自旋获取锁，直到成功
            if(!isLocked){
                for(;;){
                    isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
                    if(isLocked){
                        break;
                    }
                }
            }
            //启动新线程来执行定时任务，更新锁过期时间
            //new Thread(new UpdateLockTimeoutTask(uuid, stringRedisTemplate, key)).start();
        }else{
            isLocked = true;
        }
        //加锁成功后将计数器加1
        if(isLocked){
            Integer count = threadLocalInteger.get() == null ? 0 : threadLocalInteger.get();
            threadLocalInteger.set(count++);
        }
        return isLocked;
    }
    @Override
    public void releaseLock(String key){
        //当前线程中绑定的uuid与Redis中的uuid相同时，再执行删除锁的操作
        String uuid = stringRedisTemplate.opsForValue().get(key);
        if(threadLocal.get().equals(uuid)){
            Integer count = threadLocalInteger.get();
            //计数器减为0时释放锁
            if(count == null || --count <= 0){
                stringRedisTemplate.delete(key);
                //获取更新锁超时时间的线程并中断
                //long threadId = stringRedisTemplate.opsForValue().get(uuid);
                Thread updateLockTimeoutThread = ThreadUtils.getThreadByThreadId(new Long(1L));
                if(updateLockTimeoutThread != null){
                    //中断更新锁超时时间的线程
                    updateLockTimeoutThread.interrupt();
                    stringRedisTemplate.delete(uuid);
                }
            }
        }
    }
}
