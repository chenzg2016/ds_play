package com.czg.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzg
 * @date 2019.01.07 23:32
 * @description
 **/
public class AtomCompare {
    private int value;

    public AtomCompare(int value) {
        this.value = value;
    }

    public synchronized int increase() {
        return value++;
    }

    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        AtomCompare test = new AtomCompare(0);
        for (int i = 0; i < 100000000; i++) {
            test.increase();
        }
        long end = System.currentTimeMillis();
        System.out.println("time elapse:" + (end - start));

        long start1 = System.currentTimeMillis();

        AtomicInteger atomic = new AtomicInteger(0);

        for (int i = 0; i < 100000000; i++) {
            atomic.incrementAndGet();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("time elapse:" + (end1 - start1));

    }
}