package com.jconcurrency.ch01;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 2020-12-10 20:01
 * @description
 */
public class TryConcurrency {

    public static void main(String[] args) {
        news();
        sleep();

    }


    private static void news(){


        for (;;) {
            System.out.println("good news....");
            sleep();
        }
    }

    private static void music(){


        for (;;) {
            System.out.println("good music....");
            sleep();
        }
    }

    private static void sleep(){

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
