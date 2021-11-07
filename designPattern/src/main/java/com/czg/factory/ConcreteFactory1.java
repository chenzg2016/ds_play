package com.czg.factory;

/**
 * @author chenzg
 * @date 2020-05-20 15:37
 * @description
 */
public class ConcreteFactory1 implements AbstractFactory {

    @Override
    public Product newProduct()
    {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}
