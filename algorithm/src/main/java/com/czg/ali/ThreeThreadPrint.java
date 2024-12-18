package com.czg.ali;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzg
 * @date 8/8/24 11:52 AM
 * @description
 */
public class ThreeThreadPrint {

    private static  int state = 0;

    private static final int TOTAL = 100;
    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition A = lock.newCondition();

    private static final Condition B = lock.newCondition();

    private static final Condition C = lock.newCondition();


    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                    try {
                        for (int i = 0; i < TOTAL; i++) {

                            lock.lock();
                            try {
                                while (state % 3 != 0 ) {
                                    A.await();
                                }
                                System.out.println("A");
                                state++;
                                B.signal();
                            }finally {
                                lock.unlock();
                            }
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }


            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < TOTAL; i++) {

                        lock.lock();
                        try {
                            while (state % 3 != 1 ) {
                                B.await();
                            }
                            System.out.println("B");
                            state++;
                            C.signal();
                        }finally {
                            lock.unlock();
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });


        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < TOTAL; i++) {

                        lock.lock();
                        try {
                            while (state % 3 != 2 ) {
                                C.await();
                            }
                            System.out.println("C");
                            state++;
                            A.signal();
                        }finally {
                            lock.unlock();
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });


        //Thread t1 = new Thread(new Runnable() {
        //
        //    @Override
        //    public void run() {
        //        System.out.println("A");
        //    }
        //});
        //
        //Thread t2 = new Thread(new Runnable() {
        //
        //    @Override
        //    public void run() {
        //        try {
        //            t1.join();
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //        System.out.println("B");
        //    }
        //});
        //
        //
        //Thread t3 = new Thread(new Runnable() {
        //
        //    @Override
        //    public void run() {
        //        try {
        //            t2.join();
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //        System.out.println("C");
        //    }
        //});

            t1.start();
            t2.start();
            t3.start();




    }

}
