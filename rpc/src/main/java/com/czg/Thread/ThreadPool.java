package com.czg.Thread;

import org.omg.SendingContext.RunTime;

/**
 * @author chenzhigong
 * @date 2018-08-09 09:02
 * @description
 **/
public class ThreadPool {

    private static final int corePoolSize = Runtime.getRuntime().availableProcessors();
    private static final long freeMemory = Runtime.getRuntime().freeMemory();
    private static final long totalMemory = Runtime.getRuntime().totalMemory();

    public static void main(String[] args) {
        System.out.println(freeMemory);
        System.out.println(totalMemory);
        System.out.println(corePoolSize);
    }
}
