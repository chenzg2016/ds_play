package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.12 22:19
 * @description
 **/
public class PrimarySample implements Runnable {
    private  int count = 0;

    private void count(){
        count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count();
            System.out.println("循环索引：" + i + "，线程名称：" + Thread.currentThread().getName() + "，计数器值：" + count);
        }
    }
}
