package com.czg.concurrent.container;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenzg
 * @date 7/30/21 4:31 PM
 * @description
 */
public class BlockingQueue1<T> {
    private Queue<T> mQueue = new LinkedList<>();
    private int mCapacity;

    public BlockingQueue1(int capacity) {
        this.mCapacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException{
        while (mQueue.size() == mCapacity){
            wait();
        }
        mQueue.add(element);
        notify();
    }

    public synchronized T take() throws InterruptedException{
        while (mQueue.isEmpty()){
            wait();
        }
        T item = mQueue.remove();
        notify();
        return item;
    }
}
