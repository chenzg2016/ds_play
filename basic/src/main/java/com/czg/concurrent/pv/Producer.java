package com.czg.concurrent.pv;

/**
 * @author chenzg
 * @date 2018.08.22 10:02
 * @description
 **/
public class Producer implements Runnable{

    /**
     *所在放置的仓库
     */
    private StoreHouse store;

    private int num;


    public Producer(StoreHouse store){

        this.store = store;
    }


    @Override
    public void run() {
        produce(num);
    }


    public void produce(int num){
        store.produce(num);
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
