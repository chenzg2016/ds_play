package com.czg.factory;

/**
 * @author chenzg
 * @date 2020-05-20 15:39
 * @description
 */
public class ConcreteFactory2  implements AbstractFactory {

    @Override
    public Product newProduct()
    {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}
