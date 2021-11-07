package com.czg.dataType;

/**
 * @author chenzg
 * @date 2019.04.24 19:58
 * @description
 **/
public class WapperDataTypeTest {

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a==b);
        Integer a1 = 128;
        Integer b1 = 128;
        System.out.println(a1 == b1);
        System.out.println(a1.equals(b1));
        Integer a2 = -128;
        Integer b2 = -128;
        System.out.println(a2 == b2);

        Long c = 127L;
        Long d = 127L;
        System.out.println(c == d);
    }
}
