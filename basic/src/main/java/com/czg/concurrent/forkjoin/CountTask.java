package com.czg.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author chenzg
 * @date 10/3/21 10:12 PM
 * @description
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 10;

    private Integer start;

    private Integer end;

    public CountTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        Integer sum = 0;
        if (end - start <= THRESHOLD) {
            for (Integer n = start; n <= end; n++) {
                sum += n;
            }
        } else {
            Integer middle = (end + start) / 2;

            CountTask task1 = new CountTask(start,middle);

            CountTask task2 = new CountTask(middle + 1, end);

            task1.fork();
            task2.fork();

            Integer result1 = task1.join();

            Integer result2 = task2.join();

            sum = result1 + result2;

        }
        return sum;
    }

}
