package com.czg.factory;

/**
 * @author chenzg
 * @date 2020-05-20 15:35
 * @description
 */
public class ConcreteProduct1 implements Product {
    @Override
    public void show()
    {
        System.out.println("具体产品1显示...");
    }
}
