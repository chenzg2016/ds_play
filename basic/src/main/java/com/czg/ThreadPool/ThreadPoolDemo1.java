package com.czg.ThreadPool;

import java.util.concurrent.*;

/**
 * @author chenzg
 * @date 2018.08.29 20:45
 * @description
 **/
public class ThreadPoolDemo1 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(5,9,60,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(5,9,60,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        ThreadPoolExecutor executor3 = new ThreadPoolExecutor(5,9,60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(8));
//        ThreadPoolExecutor executor4 = new ThreadPoolExecutor(5,9,60,TimeUnit.SECONDS,new DelayQueue<Runnable>());


//        ThreadPoolExecutor executor5 = (ThreadPoolExecutor)Executors.newFixedThreadPool(6);
        ExecutorService executor6 = Executors.newCachedThreadPool();
        ScheduledExecutorService executor7 = Executors.newScheduledThreadPool(6);
        ExecutorService executor8 = Executors.newSingleThreadExecutor();
        for(int i=0;i<20;i++){
            MyTask myTask = new MyTask(i);
//            executor5.execute(myTask);
//            executor6.execute(myTask);
//            executor7.execute(myTask);
//            executor1.execute(myTask);
//            executor2.execute(myTask);
            executor3.execute(myTask);
            System.out.println("ActiveCount = " +executor3.getActiveCount());
            System.out.println("PoolSize = " + executor3.getPoolSize());
            System.out.println("Queue = "+ executor3.getQueue());
//            executor4.execute(myTask);
//            System.out.println("线程池中线程数目："+executor1.getPoolSize()+"，队列中等待执行的任务数目："+
//                    executor1.getQueue().size()+"，已执行完别的任务数目："+executor1.getCompletedTaskCount());
//            System.out.println("线程池中线程数目："+executor2.getPoolSize()+"，队列中等待执行的任务数目："+
//                    executor2.getQueue().size()+"，已执行完别的任务数目："+executor2.getCompletedTaskCount());
//            System.out.println("线程池中线程数目："+executor6.getPoolSize()+"，队列中等待执行的任务数目："+
//                    executor6.getQueue().size()+"，已执行完别的任务数目："+executor6.getCompletedTaskCount());
        }
//        executor1.shutdown();
//        executor2.shutdown();
        executor3.shutdown();
//        executor4.shutdown();
//        executor5.shutdown();
//        executor6.shutdown();
//        executor7.shutdown();
//        executor8.shutdown();

    }
}
