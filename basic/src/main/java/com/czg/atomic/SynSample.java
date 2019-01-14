package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.07 23:28
 * @description
 **/
public class SynSample {
    private     Integer count = 0;

    public   static   synchronized  void count() {
///        count++;
    }

    public static void main(String[] args) {
        count();
    }
    //implements Runnable
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            count();
//            System.out.println("循环索引：" + i + "，线程名称：" + Thread.currentThread().getName() + "，计数器值：" + count);
//            System.out.println("活跃线程数："+Thread.activeCount());
//        }
//    }
}