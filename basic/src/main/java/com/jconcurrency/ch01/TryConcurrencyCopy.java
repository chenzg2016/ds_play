package com.jconcurrency.ch01;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 2020-12-10 20:01
 * @description
 */
public class TryConcurrencyCopy {

    public static void main(String[] args) {
        new Thread(){

            @Override
            public void run() {
                news();
            }
        }.start();
        music();
    }


    private static void news(){


        for (;;) {
            System.out.println("good news....");

            sleep("news");
        }
    }

    private static void music(){


        for (;;) {
            System.out.println("good music....");
            sleep("music");
        }
    }

    private static void sleep(String str){

        try {
            System.out.println(str);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
