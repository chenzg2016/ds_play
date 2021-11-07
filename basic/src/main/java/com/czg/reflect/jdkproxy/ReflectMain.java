package com.czg.reflect.jdkproxy;

/**
 * @author chenzg
 * @date 11/2/21 4:07 PM
 * @description
 */
public class ReflectMain {

    public static void main(String[] args) {

        SmsService smsService = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");


    }
}



