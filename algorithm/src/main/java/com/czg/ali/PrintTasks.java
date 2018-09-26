package com.czg.ali;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author chenzg
 * @date 2018.09.22 19:37
 * @description
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
                barrier.await();
            }
        } catch (InterruptedException e) {
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public void printNum() {
        System.out.print("线程 " + id + ": ");
        for(int i = 0; i < 5; i++) {
            System.out.format("%3d", ++num);
        }
        System.out.println();
    }

}
