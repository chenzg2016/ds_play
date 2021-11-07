package com.czg.concurrent.pvmodel;

/**
 * @author chenzg
 * @date 2018.08.22 15:21
 * @description
 **/
public interface Model {

    Runnable newRunnableProducer();

    Runnable newRunnableConsumer();
}
