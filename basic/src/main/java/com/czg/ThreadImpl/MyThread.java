package com.czg.ThreadImpl;

/**
 * @author chenzg
 * @date 2018.08.22 20:42
 * @description
 **/
public class MyThread extends Thread {
    public int x = 0;

    @Override
    public void run(){
        System.out.println(++x);
    }
}
