package com.czg.juc.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenzg
 * @date 2019.01.18 14:16
 * @description
 **/
public class NetWorkHealthChecker extends BaseHealthChecker {
    public NetWorkHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch,"NetWorkHealth");
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
