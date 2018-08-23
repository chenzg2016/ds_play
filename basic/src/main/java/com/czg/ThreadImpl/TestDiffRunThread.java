package com.czg.ThreadImpl;

/**
 * @author chenzg
 * @date 2018.08.22 20:49
 * @description
 **/
public class TestDiffRunThread {

    public static void main(String[] args) throws Exception{
        for(int i=0; i<10; i++) {
            Thread t1 = new MyThread();

            t1.start();
        }
        Thread.sleep(1000);
       RunThread run=  new RunThread();
        for(int i=0; i<10; i++) {
            Thread t = new Thread(run);
            t.start();
        }
    }


}
