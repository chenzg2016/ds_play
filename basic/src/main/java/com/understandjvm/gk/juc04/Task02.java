package com.understandjvm.gk.juc04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 11/28/21 10:22 PM
 * @description
 */
public class Task02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Future<Integer> future = pool.submit(() -> 1);

        Integer o = future.get();
        System.out.println(o);
        while (o == null) {
            Thread.currentThread().join();
        }
        pool.shutdown();
    }
}

