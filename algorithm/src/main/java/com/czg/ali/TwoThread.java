package com.czg.ali;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 2019.04.12
 * @description
 *
 *
 * 用多线程实现一个生存者消费者模型，一个线程往map里put 1-100的数字，
 *    另外一个线程负责get数字并进行累加，并打印结果
 *
 **/
public class TwoThread {

//    private static int a = 1;
//    private  static final int b = 100;
//
//    private Lock lock = new ReentrantLock();
    private Integer sum = 0;
    Map<Integer,Integer> map =  new ConcurrentHashMap<>();
//    private final Condition p = lock.newCondition();
//    private final Condition c = lock.newCondition();
    private boolean hasValue = false;

    private static Integer count = 1;
    private static final Integer FULL = 100;
    //创建一个锁对象
    private Lock lock = new ReentrantLock();
    //创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        TwoThread twoThread = new TwoThread();
        new Thread(twoThread.new Producer()).start();
        new Thread(twoThread.new Consumer()).start();


    }

//     class ProduceThread implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println(map.size());
//            for (int i = 0; i < b; i++) {
////                try {
////                    Thread.sleep(3000);
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
//                lock.lock();
//                try {
//                    map.clear();
//                    map.put(a, a);
//                    System.out.println("produce: ");
//                    System.out.println(map);
//                    while (a == b) {
//                        try {
//                            System.out.println("大于100");
//                            p.await();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    a++;
//                    System.out.println(Thread.currentThread().getName()
//                            + "生产者生产，目前总共有" + a);
//                    c.signal();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }
//    }

//     class ConsumeThread implements Runnable {
//
//        @Override
//        public void run() {
//            System.out.println(map.size());
//            for (Integer key : map.keySet()) {
//                System.out.println("--消费者---" + map.size());
//
////            for (int i = 0; i < 10; i++) {
//
////                try {
////                    Thread.sleep(3000);
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
//
//                lock.lock();
//                try {
//                    System.out.print("consume: ");
//                    System.out.println(key);
//                    sum = sum + key;
//                    System.out.println("sum = " + sum);
//                    while (map.size() == 0) {
//                        try {
//                            System.out.println("map 为 空");
//                            c.await();
//                        }catch (Exception e1){
//                          e1.printStackTrace();
//                        }
//                    }
//                    System.out.println(Thread.currentThread().getName()
//                            + "消费者消费，目前总共有" + map.size());
//
//                    p.signal();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }
//    }


    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {

                //获取锁
                lock.lock();
                try {
                    while (hasValue) {
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    map.clear();
                    map.put(i,i);
                    hasValue = true;
                    System.out.println("produce map = " + map );
                    //唤醒消费者
                    notEmpty.signal();
                } finally {
                    //释放锁
                    lock.unlock();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {

                lock.lock();
                try {
                    while (!hasValue) {
                        try {
                            notEmpty.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("consume map = " + map);
                    sum = sum + map.values().iterator().next();
                    System.out.println(sum);

                    hasValue = false;
                    notFull.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
