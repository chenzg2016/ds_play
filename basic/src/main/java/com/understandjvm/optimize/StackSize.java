package com.understandjvm.optimize;


/**
 * @author chenzg
 * @date 10/30/21 9:58 AM
 * @description
 */
public class StackSize {
   int   count = 0;
    public static void main(String[] args) {

            new StackSize().testStack();

    }

    private void test(int a, long b){

            count++;
            test(a,b);

    }

    private void testStack(){


        try {
            int c =5021354;
            long d=4777777777777777777L;
            test(c,d);
        }catch (Throwable e) {
            System.out.println(e);
            System.out.println("stack depth:" + count);
        }

    }
}
