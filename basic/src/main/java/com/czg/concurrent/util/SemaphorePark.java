package com.czg.concurrent.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author chenzg
 * @date 10/4/21 11:19 AM
 * @description
 */
public class SemaphorePark {

    public static void main(String[] args) throws InterruptedException {
        // 初始化五个车位
        Semaphore semaphore = new Semaphore(5);
        // 等所有车子
        final CountDownLatch latch = new CountDownLatch(8);
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            if (i == 5) {
                Thread.sleep(1000);
                new Thread(() -> {
                    stopCarNotWait(semaphore, finalI);
                    latch.countDown();
                }).start();
                continue;
            }
            new Thread(() -> {
                stopCarWait(semaphore, finalI);
                latch.countDown();
            }).start();
        }
        latch.await();
        log("总共还剩：" + semaphore.availablePermits() + "个车位");
    }

    private static void stopCarWait(Semaphore semaphore, int finalI) {
        String format = String.format("车牌号%d", finalI);
        try {
            semaphore.acquire(1);
            log(format + "找到车位了，去停车了");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release(1);
            log(format + "开走了");
        }
    }

    private static void stopCarNotWait(Semaphore semaphore, int finalI) {
        String format = String.format("车牌号%d", finalI);
        try {
            if (semaphore.tryAcquire()) {
                log(format + "找到车位了，去停车了");
                Thread.sleep(10000);
                log(format + "开走了");
                semaphore.release();
            } else {
                log(format + "没有停车位了，不在这里等了去其他地方停车去了");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void log(String content) {
        // 格式化
        DateTimeFormatter fmTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(fmTime) + "  "+content);
    }
}
