package com.czg.ajcp.ch04;

import com.czg.ajcp.util.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenzg
 * @date 2019.01.14 10:52
 * @description
 **/
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        SleepUtils.second(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

    }


    static class Wait implements Runnable {

        @Override
        public void run() {
            //加锁
            synchronized (lock) {
                //不满足条件就释放锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true.wait @"
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        //释放锁
                        lock.wait();
                    } catch (Exception e) {

                    }
                }
                System.out.println(Thread.currentThread() + " flag is false.running @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            //加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock.notify @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                //通知所有等待在该对象上的线程
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);

            }
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "  hold lock again. sleep @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}
