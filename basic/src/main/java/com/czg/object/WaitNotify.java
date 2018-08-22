package com.czg.object;

/**
 *
 */
public class WaitNotify {


    public static void main(String[] args) {
        final Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();

                        System.out.println("我是wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    lock.notify();
                    System.out.println("我是notify");
                }
            }
        });

        t1.start();

        try {
            t1.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }


}
