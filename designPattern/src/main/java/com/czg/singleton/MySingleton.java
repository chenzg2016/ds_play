package com.czg.singleton;

/**
 * @author chenzg
 * @date 2018.08.23 15:06
 * @description
 **/
public class MySingleton {

//    //使用volatile关键字保其可见性
    private static  volatile   MySingleton instance = null;

    private MySingleton() {
    }

    public static MySingleton getInstance() {

//        if ( instance == null){
//
//
//        //创建实例之前可能会有一些准备性的耗时工作
//                synchronized (MySingleton.class) {
//                    if (instance == null) {//二次检查
//                        instance = new MySingleton();
//                    }
//                }
//        }
//        return instance;

        if(instance == null){
            synchronized(MySingleton.class){
                if (instance == null) {
                    return new MySingleton();
                }
            }
        }
        return instance;

    }


    /**
     * 注意关键是volatile的声明
     */
//    private static volatile MySingleton instance = null;
//    private MySingleton(){
//    }
//    public static MySingleton getInstance() {
//        if(instance == null){
//            synchronized(MySingleton.class){
//                if (instance == null) {
//                    return new MySingleton();
//                }
//            }
//        }
//        return instance;
//    }
}
