package com.czg.dubbo.spi.jdk;

/**
 * @author chenzg
 * @date 7/23/21 4:42 PM
 * @description
 */
public class BMWCar implements Car {

    @Override
    public void getPrice() {
        System.out.println("BMWCar sell price is 30w RMB.");
    }
}
