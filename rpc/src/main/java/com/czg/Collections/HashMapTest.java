package com.czg.Collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenzhigong
 * @date 2018-08-09 16:04
 * @description
 **/
public class HashMapTest {

    public static void main(String[] args) {
        Map<String,String>  map = new HashMap<>();
        Collection<String> values = map.values();
        map.put("1","我");
        map.put("2","是");
        map.put("3","谁");

        map.get("1");

        Map<String, List<String>> m = new HashMap<>();

    }
}
