package com.czg.proxy;

/**
 * @author chenzg
 * @date 2018.08.24 17:38
 * @description
 **/
public class DynamicProxyApp {

    public static void main(String[] args) {
        IUserDao target = new UserDao();

        System.out.println(target.getClass());

        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();

        System.out.println(proxy.getClass());

        proxy.save();
    }
}
