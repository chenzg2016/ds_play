package com.czg.object;

/**
 * @author chenzg
 * @date 2018.09.17 22:17
 * @description
 **/
public class Demo {
    public static void main(String[] args)
    {
        SuperClass clz = new SubClass();
        //你觉得这里输出什么?
        System.out.println(clz.name);
    }

}
