package com.czg.singleton;

/**
 * @author chenzg
 * @date 2018.08.23 15:04
 * @description
 **/
public class TestSingleton2 extends Thread {

    @Override
    public void run() {
        System.out.println(Singleton.getInstance().hashCode());
    }

    public static void main(String[] args) {

        TestSingleton2[] mts = new TestSingleton2[10];
        for (int i = 0; i < mts.length; i++) {
            mts[i] = new TestSingleton2();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }

    }

}
