package com.czg.juc.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenzg
 * @date 2019.01.18 12:25
 * @description
 **/
public abstract class BaseHealthChecker implements Runnable {

    private CountDownLatch downLatch;

    private String serviceName;

    private boolean serviceUp;

    public BaseHealthChecker(CountDownLatch countDownLatch, String serviceName) {
        super();
        this.downLatch = countDownLatch;
        this.serviceName = serviceName;
        this.serviceUp = false;
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }

    @Override
    public void run() {
        try{
            verifyService();
            serviceUp = true;
        }catch (Throwable t){
            System.out.println(t.getCause());

        }finally {
            if (downLatch != null) {
                downLatch.countDown();
            }

        }

    }

    public abstract void verifyService();


}
