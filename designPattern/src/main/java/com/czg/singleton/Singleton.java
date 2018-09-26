package com.czg.singleton;

/**
 * @author chenzhigong
 * @date 2018-08-09 17:12
 * @description
 **/
public class Singleton {

    /**
     * 注意关键是volatile的声明
     */
    private static volatile Singleton instance = null;
    private Singleton(){
    }
    public static Singleton getInstance() {
        if(instance == null){
            synchronized(Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
