package com.czg.container;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzg
 * @date 2018.08.29 12:11
 * @description
 **/
public class ListTest {
    static final int N=500000;
    static long timeList(List list){
        long start=System.currentTimeMillis();
        Object o = new Object();
        for(int i=0;i<N;i++) {
            list.add(0, o);
        }
        return System.currentTimeMillis()-start;
    }
    static long readList(List list){
        long start=System.currentTimeMillis();
        for(int i=0,j=list.size();i<j;i++){

        }
        return System.currentTimeMillis()-start;
    }

    static List addList(List list){
        Object o = new Object();
        for(int i=0;i<N;i++) {
            list.add(0, o);
        }
        return list;
    }
    public static void main(String[] args) {
        List<Integer> shopUpdateList = new ArrayList<>();
        //testListSize(shopUpdateList);
//        System.out.println("ArrayList添加"+N+"条耗时："+timeList(new ArrayList()));
//        System.out.println("LinkedList添加"+N+"条耗时："+timeList(new LinkedList()));
//
//        List list1=addList(new ArrayList<>());
//        List list2=addList(new LinkedList<>());
//        System.out.println("ArrayList查找"+N+"条耗时："+readList(list1));
//        System.out.println("LinkedList查找"+N+"条耗时："+timeList(list2));

        shopUpdateList.add(1);
        shopUpdateList.add(2);
        shopUpdateList.add(3);

        List<Integer> bigList = new ArrayList<>();
        bigList.add(1);
        bigList.add(2);
        bigList.add(3);
        bigList.add(4);
        bigList.add(1);
        bigList.add(2);
        bigList.add(3);
        bigList.add(4);
        System.out.println(shopUpdateList.removeAll(bigList));

        System.out.println(shopUpdateList);



    }


    public static void testListSize(List list){
        for(int i=0;i<1000;i++) {

            list.add(i);
            System.out.println("-------list.size()-----------"+ list.size());
            if (list.size() >= 500) {
                System.out.println("大于500");
                list = new ArrayList<>(500);
            }

        }
    }
}
