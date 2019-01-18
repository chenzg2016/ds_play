package com.czg.ali;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author chenzg
 * @date 2018.09.22 19:37
 * @description
 * public int await() throws InterruptedException, BrokenBarrierException { };
 * public int await(long timeout, TimeUnit unit)throws InterruptedException,BrokenBarrierException,TimeoutException { };
 * 第一个 await方法用来挂起当前线程，用来等待所有线程都到达 barrier状态 再同时执行后续任务
 * 第二个 await方法用来让这些线程等待至一定时间，如果还有线程没有到达barrier状态 则先到达的线程继续执行后续任务
 **/
public class PrintTasks implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private static volatile int num = 0;

    private CyclicBarrier barrier;
    public PrintTasks(CyclicBarrier b) {
        barrier = b;
    }

    public synchronized int getNum() {
        return num;
    }


    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");

                barrier.await();
            }
        } catch (InterruptedException e) {
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("所有线程写入完毕，继续处理其他任务...");

    }

    public void printNum(int FINAL_NUM) {
        System.out.print("线程 " + id + ": ");
        for(int i = 0; i < 5; i++) {
            if (num < FINAL_NUM){
                System.out.format("%6d", ++num);
            }

        }
        System.out.println();
    }

}
