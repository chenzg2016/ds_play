package com.czg.concurrent.pvmodel;

/**
 * @author chenzg
 * @date 2018.08.22 15:17
 * @description
 **/
public interface Consumer {
    void consume() throws InterruptedException;
}
