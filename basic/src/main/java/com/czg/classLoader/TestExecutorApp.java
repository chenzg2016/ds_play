package com.czg.classLoader;

/**
 * @author chenzg
 * @date 2018.09.01 15:23
 * @description
 **/
public class TestExecutorApp {

    public static void main(String[] args) {
        testExecuteV1();
        testExecuteV2();
    }

    public static void testExecuteV1() {

        Executor executor = new ExecutorProxy("v1");

        executor.execute("TOM");
    }
    public static void testExecuteV2() {

        Executor executor = new ExecutorProxy("v2");

        executor.execute("TOM");
    }
}
