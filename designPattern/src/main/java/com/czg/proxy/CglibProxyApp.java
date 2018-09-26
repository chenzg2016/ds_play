package com.czg.proxy;

/**
 * @author chenzg
 * @date 2018.08.24 20:47
 * @description
 **/
public class CglibProxyApp {

    public static void main(String[] args) {
        UserDao target = new UserDao();

        UserDao proxy = (UserDao)new CglibProxyFactory(target).getProxyInstance();

        proxy.save();
    }
}
