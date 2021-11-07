package com.czg.concurrent.lock.support.三个线程顺序执行;

/**
 * @author chenzg
 * @date 7/30/21 3:56 PM
 * @description
 */
public class ConditionDemon {

    public static void main(String[] args) {
        shareData share = new shareData();
        new Thread(() -> {
            for (int i = 0; i < 3; i++)
                share.printA();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++)
                share.printB();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++)
                share.printC();
        }, "C").start();
    }
}
