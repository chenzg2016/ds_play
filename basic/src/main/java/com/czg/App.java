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
    }


}
