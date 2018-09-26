package com.czg;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        byte a = 127;

        byte b = 127;

//        b = a + b; // error : cannot convert from int to byte

        b += a; // ok

        System.out.println(Thread.currentThread().getContextClassLoader());;  // 使用当前线程的ClassLoader

          // 使用系统ClassLoader，即系统的入口点所使用的ClassLoader。

        System.out.println(ClassLoader.getSystemClassLoader());


        System.out.println(490806430 % 3);

    }

    private  void print(){
//        this.getClass.getClassLoader();  // 使用当前类的ClassLoader

    }


}
