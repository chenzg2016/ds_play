package com.czg.spring.bean;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author chenzg
 * @date 2019.01.24 16:02
 * @description
 **/
public interface HelloWorldService {

     void sayHello() ;

     String getBeanName();
}
