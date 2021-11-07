package com.czg.concurrent.threadlocal.eg2;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 8/3/21 9:19 PM
 * @description
 */
public class NumUtil {

    public static int addNum = 0;

    public static int add10(int num) {
        addNum = num;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return addNum + 10;
    }
}
