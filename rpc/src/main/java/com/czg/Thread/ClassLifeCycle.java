package com.czg.Thread;

/**
 * @author chenzhigong
 * @date 2018-08-08 21:28
 * @description
 **/
public class ClassLifeCycle {
    short a;
    int b;
    long c;
    float d;
    double e;
    byte f;
    boolean g;
    char h;
    public void primaryDefaultValue(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
     }

    public static void main(String[] args) {
        ClassLifeCycle classLifeCycle = new ClassLifeCycle();
        classLifeCycle.primaryDefaultValue();
    }
}
