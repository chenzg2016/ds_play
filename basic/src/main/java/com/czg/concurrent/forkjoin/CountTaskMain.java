package com.czg.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @author chenzg
 * @date 10/3/21 10:41 PM
 * @description
 */
public class CountTaskMain {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask task = new CountTask(1,100);

        Future<Integer> future = forkJoinPool.submit(task);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
