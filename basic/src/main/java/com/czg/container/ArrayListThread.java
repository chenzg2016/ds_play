package com.czg.container;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzg
 * @date 2019.01.15 10:05
 * @description arrayList 不是线程安全的容器
 **/
public class ArrayListThread {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        new Thread(()->{
            for (int i=0; i<10; i++) {
                list.add(i);
            }
        }).start();

        new Thread(()->{
            for (int i=0; i<10; i++) {
                list.add(i);
            }
        }).start();
        System.out.println(list.size());
        list.forEach(o-> System.out.println(o+" "));

    }
}
