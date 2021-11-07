package com.czg.concurrent.util.countDownLatchDemo;

/**
 * @author chenzg
 * @date 2019.01.18 16:29
 * @description
 **/
public class Main {
    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.doCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);

    }
}
