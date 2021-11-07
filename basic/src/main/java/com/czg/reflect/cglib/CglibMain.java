package com.czg.reflect.cglib;

/**
 * @author chenzg
 * @date 11/2/21 4:24 PM
 * @description
 */
public class CglibMain {

    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }

}
