package com.czg.container;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzg
 * @date 2019.01.14 21:08
 * @description
 **/
public class MapThread implements Runnable{

    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2);
    static AtomicInteger at = new AtomicInteger();


    @Override
    public void run() {
        while(at.get() < 100000)
        {
            map.put(at.get(),at.get());
            at.incrementAndGet();
        }
    }
}
