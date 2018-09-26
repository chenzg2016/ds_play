package com.czg.classLoader;

import java.lang.reflect.Method;

/**
 * @author chenzg
 * @date 2018.09.01 15:20
 * @description
 **/
public class ExecutorProxy implements Executor {

    private String version;
    private StandardExecutorClassLoader classLoader;

    public ExecutorProxy(String version) {
        this.version = version;
        classLoader = new StandardExecutorClassLoader(version);
    }

    @Override
    public void execute(String name) {
        try {
            // Load ExecutorProxy class
            Class<?> executorClazz = classLoader.loadClass("Executor" + version.toUpperCase());

            Object executorInstance = executorClazz.newInstance();
            Method method = executorClazz.getMethod("execute", String.class);

            method.invoke(executorInstance, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
