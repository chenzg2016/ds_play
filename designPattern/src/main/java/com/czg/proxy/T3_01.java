package com.czg.proxy;


import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

/**
 * @author chenzg
 * @date 2018.09.26 20:15
 * @description
 **/
class T3_01 implements MethodHandler {
    private T3 t3;

    public T3_01(T3 t3) {
        this.t3 = t3;
    }

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        System.out.println("ccc before");
        method.invoke(new T3(), objects);
        System.out.println("ccc after");
        return o;
    }
}
