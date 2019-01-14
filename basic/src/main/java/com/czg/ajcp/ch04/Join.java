package com.czg.ajcp.ch04;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 2019.01.14 11:42
 * @description join 其实就是用的 wait 方法
 **/
public class Join {
    public static void main(String[] args) throws Exception{
        Thread previos = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previos), String.valueOf(i));
            thread.start();
            previos = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }


    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
