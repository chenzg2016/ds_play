package com.czg.concurrent.lock.support.三个线程顺序执行;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 7/31/21 10:21 AM
 * @description
 * 三个线程 顺序输出1-100
 * 示例
 * 线程1：1
 * 线程2：2
 * 线程3：3
 * 线程1：4
 * 线程2：5
 * 线程3：6
 * ....
 * 到100结束
 */
public class PrintOrderedNumDemo {

    private volatile int begin = 1 ;

    private static final int end = 100;

    Lock lock = new ReentrantLock();
    Condition conditionOne = lock.newCondition();
    Condition conditionTwo = lock.newCondition();
    Condition conditionThree = lock.newCondition();

    boolean oneFlag = true;
    boolean twoFlag = false;
    boolean threeFlag = false;
    public static void main(String[] args) {
        PrintOrderedNumDemo printOrderedNumDemo = new PrintOrderedNumDemo();
        new Thread(printOrderedNumDemo.new ThreadOne()).start();
        new Thread(printOrderedNumDemo.new ThreadTwo()).start();
        new Thread(printOrderedNumDemo.new ThreadThree()).start();

    }


    class ThreadOne implements Runnable{

        @Override
        public void run() {
            lock.lock();

            try {
                while (!oneFlag){
                    conditionOne.await();
                }
                while (begin <= end) {
                    System.out.println(begin);
                    begin ++;
                    twoFlag=true;
                    conditionTwo.signal();
                }


            }catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }


    class ThreadTwo implements Runnable {

        @Override
        public void run() {
            lock.lock();

            try {
                while (!twoFlag) {
                    conditionTwo.await();
                }
                while (begin <= end) {
                    System.out.println(begin++);
                    threeFlag = true;
                    conditionThree.signal();
                }
            }catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }


    class ThreadThree implements Runnable {

        @Override
        public void run() {
            lock.lock();

            try {
                while (!threeFlag) {
                    conditionThree.await();
                }
                while (begin <= end) {
                    System.out.println(begin++);
                    oneFlag = true;
                    conditionOne.signal();
                }
            }catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }
}
