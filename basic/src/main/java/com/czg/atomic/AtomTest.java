package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.07 23:26
 * @description
 **/
public class AtomTest {
    public static void main(String[] args) throws InterruptedException {
        AtomThread at = new AtomThread();
        Thread atThread = new Thread(at);
        Thread atThread1 = new Thread(at);
        Thread atThread2 = new Thread(at);
        Thread atThread3 = new Thread(at);
        Thread atThread4 = new Thread(at);
        Thread atThread5 = new Thread(at);
        atThread.start();
//        atThread.join();
        atThread1.start();
//        atThread1.join();
        atThread2.start();
        atThread3.start();
        atThread4.start();
        atThread5.start();
    }
}
