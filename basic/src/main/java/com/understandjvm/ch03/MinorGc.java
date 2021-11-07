package com.understandjvm.ch03;

/**
 * @author chenzg
 * @date 2019.03.08 10:52
 * @description
 **/
public class MinorGc {
    private static final int _1MB = 1024 * 1024;

    /**
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * -XX:+UseSerialGC
     */
    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;

//        allocation1 = new byte[2 * _1MB];
//        allocation2 = new byte[2 * _1MB];
//        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
