package com.czg.singleton;

/**
 * @author chenzg
 * @date 2018.08.23 14:43
 * @description
 **/
public class TestSingleton {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance().hashCode());
            }
        });

        Thread t2 = new Thread(new Run());

        Thread t3 = new Thread(new Run());

        t1.start();
        t2.start();
        t3.start();


    }

    static class Run implements Runnable{
        @Override
        public void run() {
            System.out.println(Singleton.getInstance().hashCode());
        }
    }
}
