package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.11 16:38
 * @description
 **/
public class VolatileTest {
    public static void main(String[] args) {
        VolatileSample vs = new VolatileSample();
        Thread t1 = new Thread(vs);
        Thread t2 = new Thread(vs);
        Thread t3 = new Thread(vs);
        Thread t4 = new Thread(vs);
        Thread t5 = new Thread(vs);
        Thread t6 = new Thread(vs);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
