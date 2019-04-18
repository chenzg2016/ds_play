package com.czg.string;

/**
 * @author chenzg
 * @date 2019.04.04 11:25
 * @description
 **/
public class StringTest {
    public static void main(String[] args) {
        String a = "helloworld";
        String b = "hello";
        String c = "world";
        String d = b + c;
        String e = new String("helloworld");
        System.out.println(a == d);
        System.out.println(a == e);
        System.out.println(a.equals(d));
        System.out.println(a.equals(e));
        System.out.println(d.equals(e));
    }
}
