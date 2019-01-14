package com.czg.atomic;

/**
 * @author chenzg
 * @date 2019.01.09 10:12
 * @description
 **/

public class VolatileExample1 {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {
        private volatile boolean isRunning = true;
        public boolean isRunning() {
            return isRunning;
        }
        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }
        @Override
        public void run() {
            System.out.println("进入到run方法中了");
            while (isRunning == true) {
            }
            System.out.println("线程执行完成了");
        }
    }
}
