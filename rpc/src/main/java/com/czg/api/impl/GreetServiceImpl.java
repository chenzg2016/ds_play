package com.czg.api.impl;

import com.czg.api.GreetService;

/**
 * @author chenzg
 * @date 2019.04.02 10:41
 * @description
 **/
public class GreetServiceImpl implements GreetService {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
