package com.czg.concurrent.threadlocal.eg2;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 8/3/21 9:19 PM
 * @description
 */
public class NumUtil22 {

    public static ThreadLocal<Integer> addNum = new ThreadLocal();

    public static int add10(int num) {
        addNum.set(num);;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return addNum.get() + 10;
    }
}
