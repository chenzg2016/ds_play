package com.czg.concurrent.synchronize;

/**
 * @author chenzg
 * @date 7/28/21 11:23 AM
 * @description
 *
 * 对象锁和类锁并非同一个锁
 */
public class ObjectAndClassSynLock {

    public synchronized void test1() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        ObjectAndClassSynLock objectAndClassSynLock = new ObjectAndClassSynLock();

        Thread test1 = new Thread(new Runnable() {
            @Override
            public void run() {
                objectAndClassSynLock.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectAndClassSynLock.test2();
            }
        }, "test2");

        test1.start();
        test2.start();
    }

}
