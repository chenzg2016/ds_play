package com.czg.concurrent.util;

import com.czg.classLoader.Executor;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenzg
 * @date 8/4/21 10:50 AM
 * @description
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(new Runnable() {

            @Override
            public void run() {
                String A =  "银行流水A";
                try {
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {

            @Override
            public void run() {
                String B = "银行流水B";

                try {
                    String A = exgr.exchange(B);
                    System.out.println("A和 B 数据是否一致:" + A.equals(B) + ",A 录入的是：" + A + ",B 录入是：" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        threadPool.shutdown();
    }


}
