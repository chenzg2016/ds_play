package com.czg.dubbo.spi.jdk;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author chenzg
 * @date 7/23/21 4:53 PM
 * @description
 */
public class JdkSpiDemo {

    public static void main(String[] args) {
        ServiceLoader<Car> carServiceLoader = ServiceLoader.load(Car.class);

        Iterator<Car> carIterator = carServiceLoader.iterator();

        while (carIterator.hasNext()) {
            Car car = carIterator.next();
            car.getPrice();
        }
    }
}
