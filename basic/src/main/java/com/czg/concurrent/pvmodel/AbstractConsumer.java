package com.czg.concurrent.pvmodel;

/**
 * @author chenzg
 * @date 2018.08.22 15:20
 * @description
 **/
 abstract class AbstractConsumer implements Consumer,Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
