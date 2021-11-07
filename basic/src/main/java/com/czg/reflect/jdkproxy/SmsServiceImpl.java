package com.czg.reflect.jdkproxy;

/**
 * @author chenzg
 * @date 11/2/21 3:54 PM
 * @description
 */
public class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
