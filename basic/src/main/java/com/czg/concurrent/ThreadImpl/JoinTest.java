package com.czg.concurrent.ThreadImpl;

/**
 * @author chenzg
 * @date 2018.08.22 21:09
 * @description
 **/
public class JoinTest {

    public static void main(String[] args) {

        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous),String.valueOf(i));
            thread.start();
            previous = thread;
        }
    }


    static class Domino implements Runnable{

        private Thread thread;
        public Domino(Thread thread){
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Terminate.");
        }
    }
}
