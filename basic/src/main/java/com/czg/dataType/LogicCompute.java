package com.czg.dataType;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenzg
 * @date 2020-05-22 09:37
 * @description
 */
public class LogicCompute {

    public static void main(String[] args) {
        List<Integer> oldAddressTypeList = Lists.newArrayList(1,2,3,4,5,6,7,8);

        List<Integer> addressSourceList = Lists.newArrayList(0,1,2,3);


        for (Integer oldAddressType:oldAddressTypeList){
            for (Integer addressSource:addressSourceList) {

                System.out.println("oldAddressType="+oldAddressType + ",addressSource="+ addressSource + ",结果=" + (oldAddressType & addressSource));
            }

        }
    }

}
