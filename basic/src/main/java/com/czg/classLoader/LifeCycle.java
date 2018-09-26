package com.czg.classLoader;

/**
 * @author chenzg
 * @date 2018.08.25 16:00
 * @description
 **/
public class LifeCycle {

    // 主函数
    public static void main(String[] argc) {
//
        getStaticField();

    }

    static LifeCycle lifeCycle = new LifeCycle();
    // 静态属性
    private static String staticField = getStaticField();
    // 静态方法块
    static {
        System.out.println(staticField);
        System.out.println("静态方法块初始化");
        System.out.println("Static Patch Initial");
    }


    // 构造函数
    public LifeCycle() {
        System.out.println("构造函数初始化");
        System.out.println("Structure Initial ");
    }

    public static String getStaticField() {
        String statiFiled = "Static Field Initial";
        System.out.println("静态属性初始化");
        return statiFiled;
    }


//    // 普通属性
    private String field = getField();

    public  String getField() {
        String filed = "Field Initial";
        System.out.println("普通属性初始化");
        return filed;
    }
    // 普通方法块
    {
        System.out.println(field);
        System.out.println("普通方法块初始化");
        System.out.println("Field Patch Initial");
    }
}
