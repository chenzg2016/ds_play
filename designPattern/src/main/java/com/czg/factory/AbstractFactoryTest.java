package com.czg.factory;

/**
 * @author chenzg
 * @date 2020-05-20 15:34
 * @description
 */
public class AbstractFactoryTest {
    public static void main(String[] args)
    {
        try
        {
            Product a;
            AbstractFactory af;
            af=(AbstractFactory) ReadXML1.getObject();
            a=af.newProduct();
            a.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
