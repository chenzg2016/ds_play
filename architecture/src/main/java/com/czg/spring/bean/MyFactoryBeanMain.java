package com.czg.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenzg
 * @date 2019.01.24 16:13
 * @description
 **/
public class MyFactoryBeanMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorldService helloWorldService = (HelloWorldService) context.getBean("fbHelloWorldService");
        helloWorldService.getBeanName();
        helloWorldService.sayHello();
    }
}
