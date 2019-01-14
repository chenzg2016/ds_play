package com.czg.ajcp.ch03;

/**
 * @author chenzg
 * @date 2019.01.09 22:09
 * @description
 **/
public class UnsafeLazyInitialization {
    private static Instance instance;

    public synchronized static Instance getInstance(){
        if (instance == null){
            instance = new Instance();
        }
        return instance;
    }

    static class  Instance {

    }
}
