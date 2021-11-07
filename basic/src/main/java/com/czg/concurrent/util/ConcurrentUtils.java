package com.czg.concurrent.util;

import java.util.concurrent.*;

/**
 * @author chenzg
 * @date 2019.01.17 11:10
 * @description
 **/
public class ConcurrentUtils {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);

        Semaphore semaphore = new Semaphore(1);

        Phaser phaser = new Phaser();

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();


        Exchanger exchanger = new Exchanger();




    }
}
