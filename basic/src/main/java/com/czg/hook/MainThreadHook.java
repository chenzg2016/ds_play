package com.czg.hook;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 2020-12-08 14:52
 * @description
 */
public class MainThreadHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("hook thread 1 is running.");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("hook thread 1 will exit.");

        }));

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("hook thread 2 is running.");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hook thread 2 will exit.");

        }));

        System.out.println("The main thread will exit. ");
    }
}
