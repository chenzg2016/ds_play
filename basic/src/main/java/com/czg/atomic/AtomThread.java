package com.czg.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzg
 * @date 2019.01.07 23:26
 * @description
 **/
public class AtomThread implements Runnable {
    private AtomicInteger count = new AtomicInteger(1);

    private void count() {
        count.incrementAndGet();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("循环索引：" + i + "，线程名称：" + Thread.currentThread().getName() + "，计数器值：" + count);
            count();
        }
    }
}
