package com.czg.ThreadPool;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzg
 * @date 2018.09.03 21:27
 * @description
 **/
public class CountExample2 {


    private final static Logger logger = LoggerFactory.getLogger(CountExample2.class);


    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {


        //这里强制类型转换时为了能设置 logger 的 Level : TRACE < DEBUG < INFO <  WARN < ERROR
        ch.qos.logback.classic.Logger logback_logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");
        logback_logger.setLevel(Level.DEBUG);

        logback_logger.error("logback_logger.error");
        logback_logger.warn("logback_logger.warn");
        logback_logger.info("logback_logger.info");
        logback_logger.debug("logback_logger.debug");
        logback_logger.trace("logback_logger.trace");

        logger.error("logger.error");
        logger.warn("logger.warn");
        logger.info("logger.info");
        logger.debug("logger.debug");
        logger.trace("logger.trace");



        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    logger.error("exception", e);
                    System.out.println(e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();

        executorService.shutdown();
        logger.info("count:{}", count.get());
//        System.out.println("count:"+ count.get());
    }
    private static void add() {
        count.incrementAndGet();
        // count.getAndIncrement();
    }

}
