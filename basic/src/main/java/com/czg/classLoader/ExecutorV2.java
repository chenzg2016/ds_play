package com.czg.classLoader;

/**
 * @author chenzg
 * @date 2018.09.01 15:25
 * @description
 **/
public class ExecutorV2 extends AbstractExecutor {

    @Override
    public void execute(final String name) {
        this.handle(new Handler() {
            @Override
            public void handle() {
                System.out.println("V2:" + name);
            }
        });
    }

}