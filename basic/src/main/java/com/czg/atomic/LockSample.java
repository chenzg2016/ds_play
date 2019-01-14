package com.czg.atomic;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 2019.01.07 23:28
 * @description
 **/
public class LockSample implements Runnable {
    private   volatile   Integer count = 0;
    ReentrantLock lock = new ReentrantLock();

    private  void count(Thread thread) {
        //lock.lock();
        if (lock.tryLock()) {
            try{
                System.out.println("线程名"+thread.getName() + "获得了锁");
                count++;
                System.out.println("线程名称：" + thread.getName() + "，计数器值：" + count);
            }finally {
                lock.unlock();
                System.out.println("线程名"+thread.getName() + "释放了锁");

            }
        }else {
            System.out.println("我是"+Thread.currentThread().getName()+"有人占着锁，我就不要啦");
            System.out.println(lock.getHoldCount());
            System.out.println(lock.hasQueuedThread(thread));
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            count(Thread.currentThread());
        }
    }
}
