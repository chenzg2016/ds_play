package com.czg.container;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzg
 * @date 2019.01.14 21:02
 * @description
 **/
public class NotThreadSafe {
    public static void main(String[] args) {
        MapThread mapThread = new MapThread();

        Thread t0 = new Thread(mapThread);
        Thread t1 = new Thread(mapThread);
        Thread t2 = new Thread(mapThread);
        Thread t3 = new Thread(mapThread);
        Thread t4 = new Thread(mapThread);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();




    }
}
