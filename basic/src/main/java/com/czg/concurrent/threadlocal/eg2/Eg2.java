package com.czg.concurrent.threadlocal.eg2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenzg
 * @date 8/3/21 9:19 PM
 * @description
 */
public class Eg2 {


    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(()->{
                System.out.println(num + " " +  NumUtil.add10(num));
            });
        }
        service.shutdown();
    }
}
