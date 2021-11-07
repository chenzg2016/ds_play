package com.czg.concurrent.lock.support;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 7/29/21 5:18 PM
 * @description 题目描述： 多线程之间按顺序调用，
 * 实现 A-> B -> C 三个线程启动，
 * 要求如下： A打印3次，B打印5次，C打印7次
 * 紧接着 A打印3次，B打印5次，C打印7次 … 来3轮
 */
public class TestCondition {
    public static void main(String[] args) {
        new TestCondition().init();
    }

    private void init(){
        Repeat repeat = new Repeat();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int j = 0; j< 100; j++) {
                    repeat.three();
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int j = 0; j< 100; j++) {
                    repeat.five();
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int j = 0; j< 100; j++) {
                    repeat.seven();
                }
            }

        }).start();

    }
    class Repeat {
        int status = 1;//开始默认执行第一个方法
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();


        void three(){
            lock.lock();

            try {

                int i = 0;

                while (i != 3) {
                    i++;
                    System.out.println("我是线程 A");
                }
                while (status != 1) {
                    condition1.await();
                }
                status = 2;
                condition2.signal();

            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }

        void five(){
            lock.lock();
            try {

                int i = 0;

                while (i != 5) {
                    i++;
                    System.out.println("我是线程 B");
                }
                while (status != 2) {
                    condition2.await();
                }
                status = 3;
                condition3.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void seven(){
            lock.lock();
            try {

                int i = 0;

                while (i != 7) {
                    i++;
                    System.out.println("我是线程 C");
                }
                while (status != 3) {
                    condition3.await();
                }
                status = 1;
                condition1.signal();

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}
