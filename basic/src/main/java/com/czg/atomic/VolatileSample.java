package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.11 16:36
 * @description
 *
 **/
public class VolatileSample implements Runnable{
    private volatile int count = 0;
    private volatile int count1 = 0;

    private void count(){
        count++;
//        count1++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count();
            System.out.println("循环索引：" + i + "，线程名称：" + Thread.currentThread().getName() + "，计数器值：" + count + "，计数器值1：" + count1);
        }
    }
}
