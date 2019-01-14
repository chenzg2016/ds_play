package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.08 14:30
 * @description
 **/


public class RunnableTest {
    public static void main(String[] args) throws InterruptedException {
        NotThreadSafe mt = new NotThreadSafe();

        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        t1.start();
        t2.start();
        Thread.sleep(500);
        System.out.println(NotThreadSafe.i);
    }
    static class NotThreadSafe implements Runnable {
        static volatile long i = 0;

        @Override
        public void run() {
            for (int m = 0; m < 10000; m++) {
                i++;
            }
        }
    }
}
