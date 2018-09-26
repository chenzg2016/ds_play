package com.czg.classLoader;

/**
 * @author chenzhigong
 * @date 2018-08-13 15:17
 * @description
 **/
public class StaticTest {

    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }


    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b + ",c=" + c);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
    final int c = 120;

    {
        System.out.println("2");
    }

}