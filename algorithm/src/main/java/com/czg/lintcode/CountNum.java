package com.czg.lintcode;

import java.util.Scanner;

/**
 * @author chenzg
 * @date 2018.09.16 15:37
 * @description 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 **/
public class CountNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int k = in.nextInt();
            int n = in.nextInt();
            System.out.println(countNum(k, n));
        }
    }


    public static int countNum(int k, int n) {
        int m = 0;
        String s = k+"";
        for (int i = 0; i <= n; i++) {
            String[] allNum = String.valueOf(i).split("");

            for (int j = 0; j < allNum.length; j++) {
                if (allNum[j].indexOf(s) == 0) {
                    m++;
                }
            }
        }


        return m;
    }


    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int m = 0;

        return m;
    }
}
