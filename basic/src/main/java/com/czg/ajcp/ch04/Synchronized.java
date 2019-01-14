package com.czg.ajcp.ch04;

/**
 * @author chenzg
 * @date 2019.01.14 10:25
 * @description
 **/
public class Synchronized {
    public static void main(String[] args) {
        synchronized(Synchronized.class) {
           m();
        }
    }

    public static synchronized void m() {

    }
}
