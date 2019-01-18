package com.czg.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenzg
 * @date 2019.01.17 20:19
 * @description
 **/
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t = new Thread(()->{
            try {
            System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
            Thread.sleep(3000);
            System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
            countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t1 = new Thread(()->{
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                countDownLatch.countDown();
            }catch (InterruptedException e) {
            e.printStackTrace();
        }
        });

        t.start();
        t1.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            countDownLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
