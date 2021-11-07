package com.understandjvm;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 2020-05-08 15:53
 * @description
 */
public class App2 {

    public static void main(String[] args) {
        // 这里把corePoolSize设为5，keepAliveTime保持不变
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
                                                             30L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(15));
        // 允许核心线程超时销毁
        executor.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

    }

}
