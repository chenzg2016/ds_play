package com.czg.reflect;

import javax.xml.ws.spi.Invoker;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chenzg
 * @date 2018.08.26 12:50
 * @description
 **/
public class MethodReflect {

    public static void main(String[] args) {
        try {
            getVariableAndMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getVariableAndMethod() throws Exception {

    Class clazz = Class.forName("com.czg.reflect.Person");

    System.out.println("**********************所有公有构造方法*********************************");
    Constructor[] constructors =  clazz.getConstructors();

    for (Constructor constructor:constructors){
        System.out.println(constructor);
    }

    System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
    constructors = clazz.getDeclaredConstructors();
    for(Constructor c : constructors){
        System.out.println(c);
    }

    System.out.println("*****************获取公有、无参的构造方法*******************************");
    Constructor con = clazz.getConstructor(null);
    //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
    //2>、返回的是描述这个无参构造函数的类对象。

    System.out.println("con = " + con);
    System.out.println("******************获取私有构造方法，并调用*******************************");
    Object obj = con.newInstance();

    con = clazz.getDeclaredConstructor(String.class);
    System.out.println(con);
    con.setAccessible(true);//暴力访问(忽略掉访问修饰符
    obj = con.newInstance("中国人");


    Field[] fields = clazz.getFields();

    for (Field field:fields){
        System.out.println(field);
    }

    Field[] declaredFields = clazz.getDeclaredFields();

    for (Field field:declaredFields){
        System.out.println(field);
    }

    System.out.println("所有public方法");
    Method[] methods = clazz.getMethods();

    for (Method method:methods){
        System.out.println(method);
    }

        System.out.println("所有方法");
    Method[] declaredMethods = clazz.getDeclaredMethods();
        Method setM = clazz.getDeclaredMethod("setSex",char.class);
        setM.invoke(obj,'1');
    for (Method method:declaredMethods){
        System.out.println(method);

    }




    }
}
