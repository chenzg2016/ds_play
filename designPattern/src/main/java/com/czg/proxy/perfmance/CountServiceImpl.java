package com.czg.proxy.perfmance;

/**
 * @author chenzg
 * @date 2018.09.26 22:22
 * @description
 **/
public class CountServiceImpl implements CountService {

    private int count = 0;

    @Override
    public int count() {
        return count ++;
    }
}