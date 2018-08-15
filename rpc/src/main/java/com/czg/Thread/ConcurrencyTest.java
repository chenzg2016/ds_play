package com.czg.Thread;

import com.czg.singleton.Singleton;

/**
 * @author chenzhigong
 * @date 2018-08-09 10:36
 * @description
 **/
public class ConcurrencyTest {
    private static final long count = 100000L;

    public static void main(String[] args) throws InterruptedException {
//        concurrency();
//        serial();
        testSingleton();
    }


    private static void concurrency() throws InterruptedException {

        long start = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                int a = 0;
                for (long i = 0; i < count; i ++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0 ;
        for ( long i = 0; i< count; i++){
            b --;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :" + time + "ms,b = " + b);
    }

    public static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i ++) {
            a += 5;
        }
        int b = 0 ;
        for ( long i = 0; i< count; i++){
            b --;
        }
        long time = System.currentTimeMillis() - start;

        System.out.println("concurrency :" + time + "ms,b = " + b);

    }

    private static void testSingleton(){
        final Singleton singleton = Singleton.getInstance();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(singleton.hashCode());
            }
        });

        Thread thead2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(singleton.hashCode());
            }
        });
        Thread thead3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(singleton.hashCode());
            }
        });
        thread1.start();
        thead2.start();
        thead3.start();
    }
}
