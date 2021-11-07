package com.czg.concurrent.pvmodel;

/**
 * @author chenzg
 * @date 2018.08.22 15:18
 * @description
 **/
abstract class AbstractProducer implements Producer,Runnable {

    @Override
    public void run() {
        while (true){
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
    }
    }
}
