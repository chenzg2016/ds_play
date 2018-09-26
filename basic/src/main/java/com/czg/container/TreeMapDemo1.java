package com.czg.container;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author chenzg
 * @date 2018.08.29 15:48
 * @description
 **/
public class TreeMapDemo1 {
    public static void main(String[] args) {
        Map<User, String> map = new TreeMap<>();

        map.put(new User("jimmy1", 30), "hello");
        map.put(new User("jimmy2", 30), "hello");
        map.put(new User("jimmy", 22), "hello");
        map.put(new User("jimmy", 20), "hello");

        Set<Map.Entry<User, String>> entrySet = map.entrySet();
        for (Map.Entry<User, String> each : entrySet) {
            System.out.println(each.getKey()+"::"+each.getValue());
        }
    }
}