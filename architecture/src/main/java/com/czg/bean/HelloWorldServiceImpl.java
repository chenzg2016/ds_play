package com.czg.bean;

/**
 * @author chenzg
 * @date 2019.01.24 16:22
 * @description
 **/
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
    @Override
    public String getBeanName(){
        return "helloWorld";
    }
}
