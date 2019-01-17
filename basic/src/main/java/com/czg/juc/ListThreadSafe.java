package com.czg.juc;

import com.czg.ThreadImpl.MyThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenzg
 * @date 2019.01.15 10:27
 * @description
 **/
public class ListThreadSafe {

        // TODO: list是ArrayList对象时，程序会出错。
//        private static List<String> list = new ArrayList<String>();
        private static List<String> list = new CopyOnWriteArrayList<String>();
        public static void main(String[] args) {

            // 同时启动两个线程对list进行操作！
            new MyThread("ta").start();
            new MyThread("tb").start();


        }

        private static void printAll(String val,int i) {
            String value = null;
            Iterator iter = list.iterator();
            while(iter.hasNext()) {
                value = (String)iter.next();
                System.out.print(value+", ");
            }
            System.out.println("线程名称="+val+"，循环索引="+i);
        }

        private static class MyThread extends Thread {
            MyThread(String name) {
                super(name);
            }
            @Override
            public void run() {
                int i = 0;
                while (i++ < 6) {
                    // “线程名” + "-" + "序号"
                    String val = Thread.currentThread().getName()+"-"+i;
                    list.add(val);
                    // 通过“Iterator”遍历List。
                    printAll(val,i);
                }
            }
        }
}
