package com.czg.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chenzg
 * @date 2018.08.24 17:33
 * @description
 **/
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("开始保存");
                        System.out.println(method.getName());
                        Object value = method.invoke(target,args);
                        System.out.println("结束保存");
                        return value;
                    }
                });


    }
}
