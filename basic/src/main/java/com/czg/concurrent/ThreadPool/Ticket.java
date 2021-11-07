package com.czg.concurrent.ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 2019.05.02 22:36
 * @description
 **/
public class Ticket implements Runnable {

    private AtomicInteger count = new AtomicInteger(10);// 剩余票数

    ReentrantLock lock = new ReentrantLock(false);
    Condition condition = lock.newCondition();
    //private volatile int count = 10;

    @Override
    public  void run() {
        //lock.lock();
        try {
            while (true) {

                // 没有余票时，跳出循环
                if (count.intValue() <= 0) {
                    break;
                }
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("显示出票信息：" + Thread.currentThread().getName() + "抢到第" + count + "张票");
                count.decrementAndGet();
                //condition.signalAll();
                //condition.await();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //lock.unlock();
            System.out.println(Thread.currentThread().getName() + "我是finally");

        }

    }
}
