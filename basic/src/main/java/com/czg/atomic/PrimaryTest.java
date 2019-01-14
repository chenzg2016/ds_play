package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.11 16:38
 * @description
 **/
public class PrimaryTest {
    public static void main(String[] args) {
        PrimarySample ps = new PrimarySample();
        Thread t1 = new Thread(ps);
        Thread t2 = new Thread(ps);
        Thread t3 = new Thread(ps);
        Thread t4 = new Thread(ps);
        Thread t5 = new Thread(ps);
        Thread t6 = new Thread(ps);
        Thread t7 = new Thread(ps);
        Thread t8 = new Thread(ps);
        Thread t9 = new Thread(ps);
        Thread t10 = new Thread(ps);
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();
//        t9.start();
//        t10.start();
    }
}
