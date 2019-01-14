package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.08 14:42
 * @description
 **/
public class AtomicIntegerTest {
    private static final int THREADS_CONUT = 20;
    public static volatile int count = 0;

    public static void increase() {
        count= count + 2;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
        System.out.println(count);
    }
}
