package com.czg.factory;

/**
 * @author chenzg
 * @date 2020-05-20 15:36
 * @description
 */
public interface AbstractFactory {

     /**
      * 新建产品
      * @return
      */
     Product newProduct();
}
