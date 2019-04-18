package com.czg.understandjvm.ch03;

/**
 * @author chenzg
 * @date 2019.03.08 11:24
 * @description
 **/
public class HandlePromotionFailure {

    private static final int _1MB = 1024 * 1024;

    /**
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:+UseSerialGC
     * -XX:MaxTenuringThreshold = 1
     * -XX:+PrintTenuringDistribution
     */
    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;

        allocation1 = new byte[2 * _1MB ];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null ;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
