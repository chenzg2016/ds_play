package com.czg.reflect.cglib;

/**
 * @author chenzg
 * @date 11/2/21 4:21 PM
 * @description
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
