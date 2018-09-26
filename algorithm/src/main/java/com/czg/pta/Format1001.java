package com.czg.pta;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author chenzg
 * @date 2018.09.15 10:22
 * @description
 **/
public class Format1001 {

    private static final Integer MAX = Integer.parseInt(new DecimalFormat("0").format(Math.pow(10,6)));

    private static final Integer MIN = -1000000;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(format(a , b));
        }

//        System.out.println(format(1000000,-1000000));
//        System.out.println("12345".substring(0,2));
    }


    public static String format(Integer a,Integer b){

        if (a <= MAX && a >= MIN && b <= MAX && b >= MIN){

            Integer d = a + b;

            System.out.println(d);

            boolean positive = false;
            if (d < 0){
                positive = true;
                d = Math.abs(d);
            }

            String sumStr = String.valueOf(d);

            int length = sumStr.length();
            StringBuilder stringBuilder = new StringBuilder();
            if (length < 3) {
                return String.valueOf(a + b);
            }else {
                String reverseStr = new StringBuilder(sumStr).reverse().toString();
                for (int i=0;i < length;i=i+3){
                    String splice ;
                    if (i+3 >= length){
                         splice = reverseStr.substring(i,length);
                        stringBuilder = stringBuilder.append(splice);
                    }else {
                         splice = reverseStr.substring(i,i+3);
                        stringBuilder = stringBuilder.append(splice).append(",");
                    }


                }
                if (positive){
                   return new StringBuilder("-").append(stringBuilder.reverse()).toString();
                }else {
                    return stringBuilder.reverse().toString();
                }

            }

        }
        return null;
    }
}
