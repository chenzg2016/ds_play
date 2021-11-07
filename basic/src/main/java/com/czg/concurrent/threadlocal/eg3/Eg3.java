package com.czg.concurrent.threadlocal.eg3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenzg
 * @date 8/3/21 10:04 PM
 * @description
 */
public class Eg3 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            service.execute(()->{
                System.out.println(DateUtil.parse("2019-06-01 16:34:30"));
            });
        }
        service.shutdown();
    }
}
