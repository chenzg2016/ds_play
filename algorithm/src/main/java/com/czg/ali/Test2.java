package com.czg.ali;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 2018.09.22 19:34
 * @description
 **/
public class Test2 {
    private static final int TASK_NUM = 3;
    private static int num = 0;
    private static int flag = 0;
    private static Lock lock = new ReentrantLock();
    private static List<Condition> list = new ArrayList<Condition>();
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static {
        for(int i = 0; i < TASK_NUM; i++){
            list.add(lock.newCondition());
        }
    }

    private static void crit() {
        if (num >= 75) {
            System.exit(1);
        }
    }

    private static void print() {
        crit();
        System.out.print(Thread.currentThread());
        for (int i = 0; i < 5; i++) {
            System.out.format("%-2d ", ++num);
        }
        System.out.println();
    }

    private static void work(int i) {
        while (!Thread.interrupted()) {
            try{
                lock.lock();
                if(flag == i){
                    crit();
                    print();
                    flag = (i + 1) % list.size();
                    list.get((i+1)%list.size()).signal();
                }else{
                    try {
                        list.get(i%list.size()).await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally{
                lock.unlock();
            }
        }
    }

    private static class Task implements Runnable {
        private final int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            work(i);
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < list.size(); i++)
            exec.execute(new Task(i));
    }

}
