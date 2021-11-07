package com.czg.reflect.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author chenzg
 * @date 11/2/21 4:06 PM
 * @description
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}
