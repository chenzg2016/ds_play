package com.czg.concurrent.ThreadImpl;

/**
 * @author chenzg
 * @date 2018.08.22 21:09
 * @description
 **/
public class JoinTest1 {

    public static void main(String[] args) {

        String[] letters = {"1","A","2", "B","3", "C", "4","D", "5","E","6","F", "7","G","8","H","9","I"};


        Thread previous = Thread.currentThread();
        for (int i = 0; i < letters.length; i++) {
            Thread thread = new Thread(new Domino(previous),letters[i]);
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
            System.out.print(Thread.currentThread().getName() );
        }
    }
}
