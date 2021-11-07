package jzoffer.integer;

/**
 * @author chenzg
 * @date 11/3/21 10:20 PM
 * @description
 */
public class IntegerDivide {

    public static void main(String[] args) {


        //double num = Math.pow(2d,5d) -1 ;
        int num = 15;
        System.out.println(num);
        int count = 1;
       while(num - 2 > 0){
            num = num -2;
            System.out.println(num);
            count++;
        }

        System.out.println(count);
    }
}
