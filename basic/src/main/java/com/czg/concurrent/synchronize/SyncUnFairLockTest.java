package com.czg.concurrent.synchronize;

/**
 * @author chenzg
 * @date 7/28/21 12:07 PM
 * @description
 */
public class SyncUnFairLockTest {

    //食堂
    private static class DiningRoom {
        //获取食物
        public void getFood() {
            System.out.println(Thread.currentThread().getName()+":排队中");
            synchronized (this) {
                System.out.println(Thread.currentThread().getName()+":@@@@@@打饭中@@@@@@@");
            }
        }
    }

    public static void main(String[] args) {
        DiningRoom diningRoom = new DiningRoom();
        //让5个同学去打饭
        for (int i=0; i<5; i++) {
            new Thread(()->{
                diningRoom.getFood();
            },"同学编号:00"+(i+1)).start();
        }
    }
}
