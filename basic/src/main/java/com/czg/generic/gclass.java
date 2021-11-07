package com.czg.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzg
 * @date 10/31/21 12:26 PM
 * @description
 */
public class gclass {

    public static void main(String[] args) {

        List<?> list = new ArrayList<String>();

        //list.add("a"); 编译不通过 内部类型是CAP

    }
}
