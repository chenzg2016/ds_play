package com.czg.dubbo.spi.jdk;

/**
 * @author chenzg
 * @date 7/23/21 4:42 PM
 * @description
 */
public class BYDCar implements Car {

    @Override
    public void getPrice() {
        System.out.println("BYDCar sell price is 20w RMB.");
    }
}
