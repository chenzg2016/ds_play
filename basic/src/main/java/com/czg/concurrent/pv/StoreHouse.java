package com.czg.concurrent.pv;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenzg
 * @date 2018.08.22 10:04
 * @description 生产者消费者模式
 **/
public class StoreHouse {

    Queue store = new LinkedList();

    static final int MAX = 100;

    public void produce(int num) {

        synchronized (store) {

            while (store.size() > MAX) {
                System.out.println("生产等待");
                try {
                    store.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("开始生产,个数为" + num);
            for (int i = 0; i <= num; i++){
                store.add(new Object());
            }

            store.notifyAll();
        }
    }

    public void consume(int num) {

        synchronized(store){
            while (store.size()== 0 ){
                System.out.println("消费等待");
                try {
                    store.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("开始消费,个数为" + num);
            for (int i = 0; i <= num; i++){
                store.poll();
            }

            store.notify();
        }

    }

}
