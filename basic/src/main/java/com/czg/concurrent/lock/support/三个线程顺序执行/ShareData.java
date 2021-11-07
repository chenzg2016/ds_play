package com.czg.concurrent.lock.support.三个线程顺序执行;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 7/30/21 3:56 PM
 * @description
 */
class shareData {

    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (number != 1) { c1.await(); }
            for (int i = 0; i < 3; i++)
                System.out.println(Thread.currentThread().getName() + "\t" + number + "\t" + i);
            number = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (number != 2)
                c2.await();
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number + "\t" + i);
            }
            number = 3;
            c3.signal();
        } catch (InterruptedException e) { e.printStackTrace(); } finally { lock.unlock(); }
    }

    public void printC() {
        lock.lock();
        try {
            while (number != 3)
                c3.await();
            for (int i = 0; i < 7; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number + "\t" + i);
            }
            number = 1;
            c1.signal();
        } catch (InterruptedException e) { e.printStackTrace(); } finally { lock.unlock(); }
    }

}
