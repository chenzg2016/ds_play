package com.czg.concurrent.util.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenzg
 * @date 2019.01.18 14:16
 * @description
 **/
public class CacheHealthChecker extends BaseHealthChecker {
    public CacheHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch,"CacheHealth");
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
