package com.czg.concurrent.pv;

/**
 * @author chenzg
 * @date 2018.08.22 11:17
 * @description
 **/
public class TestPC {

    public static void main(String[] args) {

        StoreHouse store = new StoreHouse();

        Producer p1 = new Producer(store);
        Producer p2 = new Producer(store);
        Producer p3 = new Producer(store);

        Consumer c1 =  new Consumer(store);
        Consumer c2 =  new Consumer(store);


        p1.setNum(10);
        p2.setNum(20);
        p3.setNum(90);

        c1.setNum(10);
        c2.setNum(90);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);

        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(c2);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
