package com.czg.string;

/**
 * @author chenzg
 * @date 12/18/24 11:38 AM
 * @description
 */
public class StringInitialize {

        public static void main(String[] args) {
            // 不仅地址等，内容也等
            String st1 = "abc";
            String st2 = "abc";
            System.out.println(st1 == st2);
            System.out.println(st1.equals(st2));
            // 不仅地址等，内容也等
            String st5 = "a" + "b" + "c";
            String st6 = "abc";
            System.out.println(st5 == st6);
            System.out.println(st5.equals(st6));

            // 仅内容等，但地址不等
            String st3 = new String("abc");
            String st4 = "abc";
            System.out.println(st3 == st4);
            System.out.println(st3.equals(st4));

            String st11 = "ab";
            String st22 = "abc";
            String st33 = st11 + "c";
            System.out.println(st22 == st33);

            System.out.println(st22.equals(st33));


        }


}
