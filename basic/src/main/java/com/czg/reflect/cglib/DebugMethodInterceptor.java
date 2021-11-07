package com.czg.reflect.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chenzg
 * @date 11/2/21 4:22 PM
 * @description
 */
public class DebugMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());

        Object object = methodProxy.invokeSuper(o, args);

        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());

        return object;
    }
}
