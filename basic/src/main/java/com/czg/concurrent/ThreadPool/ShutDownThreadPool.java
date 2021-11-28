package com.czg.concurrent.ThreadPool;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 11/23/21 10:06 PM
 * @description
 */
public class ShutDownThreadPool {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = new ThreadPoolExecutor(
                10,
                10,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        for (int i = 0; i < 1000; i++) {
            service.submit(() ->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("接受中断，不处理~~");
                }
                System.out.println("args = " + Arrays.deepToString(args) + Thread.currentThread().getName());
            });
        }

        service.shutdown();
    }
}
