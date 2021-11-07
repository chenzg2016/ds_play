package com.czg.concurrent.pv.ThreadImplPV;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 7/30/21 7:34 PM
 * @description
 *
 *  用多线程实现一个生存者消费者模型，一个线程往map里put 1-100的数字，
 *  另外一个线程负责get数字并进行累加，并打印结果
 */
public class ThreadPV {
    public static void main(String[] args) {
         Business business = new Business();

        new Thread(new Runnable() {

            @Override
            public void run() {
                business.put();

            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                business.add();
            }
        }).start();

    }

    static class Business{
        Map<Integer,Integer> concurrentHashMap = new ConcurrentHashMap();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        AtomicInteger num = new AtomicInteger(0);
        Integer sum = 0;

        void add(){
            lock.lock();
            try {
                while (!concurrentHashMap.isEmpty()) {
                    Set<Map.Entry<Integer,Integer>> set =  concurrentHashMap.entrySet();
                    while(set.iterator().hasNext()){
                        Integer key = set.iterator().next().getKey();
                        sum += key;
                        concurrentHashMap.remove(key);
                    }
                    System.out.println(sum);
                    condition1.signal();
                    condition2.await();
                }


            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }

        void put(){

            lock.lock();
            try {
                while (concurrentHashMap.isEmpty() && num.intValue() < 100) {
                    Integer num1 = num.incrementAndGet();
                    concurrentHashMap.put(num1,num1);
                    condition2.signal();
                    condition1.await();
                }


            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }


    }

}
