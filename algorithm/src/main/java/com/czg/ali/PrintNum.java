package com.czg.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 2018.09.22 19:36
 * @description
 **/
public class PrintNum {
    static final int FINAL_NUM = 75;
    private List<PrintTasks> tasks = new ArrayList<PrintTasks>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    public PrintNum(int nTasks, final int pause) {
        barrier = new CyclicBarrier(nTasks,new Runnable() {

            @Override
            public void run() {
                for(PrintTasks task : tasks) {
                    if (task.getNum() >= FINAL_NUM) {
                        exec.shutdownNow();
                        return;
                    } else {
                        task.printNum();
                    }
                }
            }
        });
        try {
            TimeUnit.MILLISECONDS.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < nTasks; i++) {
            PrintTasks task = new PrintTasks(barrier);
            tasks.add(task);
            exec.execute(task);
        }
    }
    public static void main(String[] args) {
        new PrintNum(3,100);
    }

}
