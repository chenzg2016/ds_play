package com.understandjvm.ch03;

/**
 * @author chenzg
 * @date 2019.03.07 22:08
 * @description
 **/
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1204;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
