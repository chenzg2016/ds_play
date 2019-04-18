package com.czg.container;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenzg
 * @date 2019.04.10 16:58
 * @description
 **/
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        map.get(3);
        System.out.println();
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
