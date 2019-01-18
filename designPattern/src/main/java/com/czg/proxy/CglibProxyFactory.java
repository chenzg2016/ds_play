package com.czg.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.omg.PortableInterceptor.Interceptor;

import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chenzg
 * @date 2018.08.24 20:27
 * @description
 **/
public class CglibProxyFactory implements org.springframework.cglib.proxy.MethodInterceptor {

    private Object target;

    public CglibProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        org.springframework.cglib.proxy.Enhancer enhancer = new org.springframework.cglib.proxy.Enhancer();

        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务...");

        Object returnValue = method.invoke(target, objects);

        System.out.println("结束事务...");
        return returnValue;
    }
}
