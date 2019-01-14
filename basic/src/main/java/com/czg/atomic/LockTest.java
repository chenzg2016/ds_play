package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.11 10:36
 * @description
 **/
public class LockTest {
    public static void main(String[] args) {
        LockSample ls = new LockSample();
        Thread t1 = new Thread(ls);
        Thread t2 = new Thread(ls);
        Thread t3 = new Thread(ls);
        Thread t4 = new Thread(ls);
        Thread t5 = new Thread(ls);
        Thread t6 = new Thread(ls);
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
    }
}
