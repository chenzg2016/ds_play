package com.czg;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        File file = new File(".");
        System.out.println(file.getCanonicalPath());

        System.out.println(file.getAbsolutePath());

        final int i = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });



        if (true) {




        }
    }
}
