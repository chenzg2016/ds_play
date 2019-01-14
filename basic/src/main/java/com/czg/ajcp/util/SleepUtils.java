package com.czg.ajcp.util;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 2019.01.14 11:01
 * @description
 **/
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e) {

        }
    }
}
