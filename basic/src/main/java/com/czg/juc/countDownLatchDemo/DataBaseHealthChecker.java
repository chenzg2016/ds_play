package com.czg.juc.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenzg
 * @date 2019.01.18 14:16
 * @description
 **/
public class DataBaseHealthChecker extends BaseHealthChecker {
    public DataBaseHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch,"DataBaseHealth");
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");

    }


}
