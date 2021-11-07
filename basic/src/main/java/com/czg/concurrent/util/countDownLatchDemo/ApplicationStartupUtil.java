package com.czg.concurrent.util.countDownLatchDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author chenzg
 * @date 2019.01.18 14:36
 * @description
 **/
public class ApplicationStartupUtil {
    static CountDownLatch countDownLatch;

    static List<BaseHealthChecker> checkers ;

    private ApplicationStartupUtil() {

    }

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    //new BlockingQueue<Runnable>()
    public static boolean doCheck() throws Exception {

        checkers = new ArrayList<>();
        countDownLatch = new CountDownLatch(3);
        checkers.add(new NetWorkHealthChecker(countDownLatch));
        checkers.add(new CacheHealthChecker(countDownLatch));
        checkers.add(new DataBaseHealthChecker(countDownLatch));
        ExecutorService threadPool = Executors.newFixedThreadPool(checkers.size());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(checkers.size(), checkers.size(), 60L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new MyThread(), new ThreadPoolExecutor.AbortPolicy());
        for (final BaseHealthChecker checker : checkers) {
            threadPool.execute(checker);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (final BaseHealthChecker checker : checkers) {
            if (!checker.isServiceUp()) {
                return false;
            }
        }
        if (countDownLatch.getCount() == 0){
            threadPool.shutdownNow();
        }
        return true;
    }


    static class MyThread implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("testThread");
            return thread;
        }
    }
}
