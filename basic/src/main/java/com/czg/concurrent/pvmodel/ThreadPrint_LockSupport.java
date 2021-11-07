package com.czg.concurrent.pvmodel;

import java.util.concurrent.locks.LockSupport;

/**
 * @author chenzg
 * @date 2020-11-08 20:21
 * @description
//打印字符串“1A2B3C4D5E6F7G8H9I”
//要求：两个线程交替打印， 一个打印数字，一个打印字符
 */
public class ThreadPrint_LockSupport {

    private static Thread numThread, letterThread;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] letters = {"A", "B", "C", "D", "E", "F", "G","H","I"};
        numThread = new Thread(() -> {
            for (int i : nums) {
                System.out.print(i);
                LockSupport.unpark(letterThread);
                LockSupport.park();
            }
            //LockSupport.unpark(letterThread);
        }, "numThread");
        letterThread = new Thread(() -> {
            for (String str : letters) {
                LockSupport.park();
                System.out.print(str);
                LockSupport.unpark(numThread);
            }
            //LockSupport.unpark(numThread);
        }, "letterThread");
        numThread.start();
        letterThread.start();
    }
    //

}
