package com.czg.ThreadImpl;

/**
 * @author chenzg
 * @date 2018.08.22 20:44
 * @description
 **/
public class RunThread implements Runnable {
    public int x = 0;
    @Override
    public void run() {
        System.out.println(++x);
    }
}
