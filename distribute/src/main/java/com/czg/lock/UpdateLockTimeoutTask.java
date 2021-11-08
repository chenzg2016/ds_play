package com.czg.lock;
import org.springframework.data.redis.core.StringRedisTemplate;


import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 8/6/21 10:48 AM
 * @description
 */
public class UpdateLockTimeoutTask implements Runnable{
    //uuid
    private long uuid;

    private StringRedisTemplate stringRedisTemplate;
    private String key;
    public UpdateLockTimeoutTask(long uuid, StringRedisTemplate stringRedisTemplate, String key){
        this.uuid = uuid;
        this.stringRedisTemplate = stringRedisTemplate;
        this.key = key;
    }
    @Override
    public void run(){
        //以uuid为key，当前线程id为value保存到Redis中
        //stringRedisTemplate.opsForValue().set(uuid, Thread.currentThread().getId());
        //定义更新锁的过期时间
        while(true){
            stringRedisTemplate.expire(key, 30, TimeUnit.SECONDS);
            try{
                //每隔10秒执行一次
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
