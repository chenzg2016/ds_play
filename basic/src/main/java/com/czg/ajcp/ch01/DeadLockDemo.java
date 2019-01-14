package com.czg.ajcp.ch01;

/**
 * @author chenzg
 * @date 2019.01.10 10:20
 * @description
 **/
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    synchronized (B){
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();

    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
