package com.czg.ajcp.ch04;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzg
 * @date 2019.01.14 11:53
 * @description ThreadLocal 即线程变量，是一个以ThreadLocal 对象为键、任意对象为值得存储结构
 **/
public class Profiler {

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
      protected Long initialValue(){
          return System.currentTimeMillis();
      }
    };

    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
       return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
