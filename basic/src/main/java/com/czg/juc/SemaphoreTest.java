package com.czg.juc;

import java.util.concurrent.*;

/**
 * @author chenzg
 * @date 2019.01.18 19:53
 * @description
 **/
public class SemaphoreTest {


    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3,
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        //使用并发库，创建缓存的线程池
        ExecutorService service = Executors.newCachedThreadPool();

        //执行任务
        for (int i = 0; i < 10; i++) {
            //记录第几个任务
            final int NO = i;

            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()
                                + "获取许可" + "(" + NO + ")，" + "剩余：" + semaphore.availablePermits());
                        Thread.sleep(1000);
                        // 访问完后记得释放 ，否则在控制台只能打印3条记录，之后线程一直阻塞
                        semaphore.release();  //释放许可
                        System.out.println(Thread.currentThread().getName() + ",剩余：" + semaphore.availablePermits());
                    } catch (Exception e) {

                    }
                }
            };
            //执行任务
//            threadPoolExecutor.execute(run);
            service.execute(run);

        }
//        threadPoolExecutor.shutdown();
        service.shutdown();

    }


}
