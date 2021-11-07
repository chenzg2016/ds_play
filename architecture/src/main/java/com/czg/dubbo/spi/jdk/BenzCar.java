package com.czg.dubbo.spi.jdk;

/**
 * @author chenzg
 * @date 7/23/21 4:43 PM
 * @description
 */
public class BenzCar implements Car {

    @Override
    public void getPrice() {
        System.out.println("BenzCar sell price is 30w RMB.");
    }
}
