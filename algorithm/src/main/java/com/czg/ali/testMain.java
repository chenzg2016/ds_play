package com.czg.ali;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenzg
 * @date 2018.09.24 12:23
 * @description
 **/
public class testMain {
    static volatile int count = 1;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new TestPrint(0,"thread1"));
        executorService.submit(new TestPrint(1,"thread2"));
        executorService.submit(new TestPrint(2,"thread3"));
    }

    static class TestPrint implements Runnable{
        private int number;
        private String threadname;
        public TestPrint(int number,String threadname){
            this.number=number;
            this.threadname=threadname;
        }

        @Override
        public void run() {
            synchronized (TestPrint.class){
                while (count<100){
                    if(count/3 % 3 == number){
                        int j = count;
//                        for(int i = j;i<j+3;i++){
                            System.out.println(threadname+"："+count);
                            count++;
//                        }
                        TestPrint.class.notifyAll();
                    }else {
                        try {
                            TestPrint.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
