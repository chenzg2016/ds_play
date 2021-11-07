package com.czg.ali;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 8/2/21 2:55 PM
 * @description
 * 用多线程实现一个生存者消费者模型，一个线程往map里put 1-100的数字，
 *    另外一个线程负责get数字并进行累加，并打印结果
 */
public class TwoThreadInEmail {
    private static int a = 1;
    private static int b = 100;

    static Lock lock = new ReentrantLock();
    static Map<Integer,Integer> map = new HashMap<>();
    static Integer sum = 0;

    static final Condition BUFFER_COND = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread(new ProduceThread());
        Thread t2 = new Thread(new ConsumeThread(sum));
        t1.start();
        t2.start();
    }

    static class ProduceThread implements Runnable{

        @Override
        public void run(){
            lock.lock();
            try {
                while (a <= b) {
                    map.put(a,a);
                    a++;
                    BUFFER_COND.signalAll();
                }

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    static class ConsumeThread implements Runnable {
        Integer sum ;
        ConsumeThread(Integer sum){
            this.sum = sum;
        }
        @Override
        public void run() {

            lock.lock();
            try {
                while (map.size() == 0) {
                    BUFFER_COND.await();
                }
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                System.out.println("consume: " );
                for (Integer key : map.keySet()) {
                    sum = sum + key;
                }
                System.out.println(sum);
                BUFFER_COND.signalAll();
            } catch (Exception e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }

}
