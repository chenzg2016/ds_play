package com.czg.ali;

/**
 * @author chenzg
 * @date 2018.09.22 19:15
 * @description
 **/
public class Test {

    int count = 0;

    public static void main(String[] args) {

        Test test = new Test();
        MyThread t1 = new MyThread(test);
        MyThread t2 = new MyThread(test);
        MyThread t3 = new MyThread(test);


        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

class MyThread implements Runnable{
    Test test;
    public MyThread(Test test){
        this.test = test;
    }

    @Override
    public void run() {
        while (test.count <= 100) {
            synchronized (test) {
                if (test.count <= 100) {
                    System.out.println(test.count++ + "线程号"
                            + Thread.currentThread().getId());
                }
            }
        }
    }
}