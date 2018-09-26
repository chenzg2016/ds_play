package com.czg.classLoader;

/**
 * @author chenzg
 * @date 2018.09.01 15:24
 * @description
 **/
public class ExecutorV1 extends AbstractExecutor {

    @Override
    public void execute(final String name) {
        this.handle(new Handler() {
            @Override
            public void handle() {
                System.out.println("V1:" + name);
            }
        });
    }

}