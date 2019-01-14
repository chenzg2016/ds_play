package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.10 14:18
 * @description
 **/
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }
}
