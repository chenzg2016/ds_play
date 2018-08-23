package com.czg.pv;

/**
 * @author chenzg
 * @date 2018.08.22 10:04
 * @description
 **/
public class Consumer implements Runnable{

    /**
     * 所在放置的仓库
     */
    private StoreHouse store;

    private int num;

    public Consumer(StoreHouse store){
        this.store = store;
    }
    @Override
    public void run() {
        consume(num);
    }

    public void consume(int num){
        store.consume(num);
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

