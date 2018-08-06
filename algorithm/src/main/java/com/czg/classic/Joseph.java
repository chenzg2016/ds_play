package com.czg.classic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author chenzhigong
 * @date 2018-08-04
 * @description
 **/
public class Joseph {

    public static void main(String[] args) {
        String str[] = new String[2];
        try {
            //先提示一段文字，然后等待用户输入
            for(int i=0; i<2; i++) {
                str[i] = readUserInput("请输入两个正整数：");
            }
            System.out.println("您输入的是：" + str[0]);
            System.out.println("您输入的是：" + str[1]);
            if (isInvalid(str[0],str[1])){
                System.out.println("第一个数必须大于第二个数！");
                return;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        queue(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
    }

    /*
     * 读取用户输入
     * @param prompt 提示文字
     * @return 用户输入
     * @throws IOException 如果读取失败
     */
    private static String readUserInput(String prompt) throws IOException {
        //先定义接受用户输入的变量
        String result;
        do {
            // 输出提示文字
            System.out.print(prompt);
            InputStreamReader is_reader = new InputStreamReader(System.in);
            result = new BufferedReader(is_reader).readLine();
            // 当用户输入无效的时候，反复提示要求用户输入
        } while (isBlank(result));
        return result;
    }


    private static boolean isInvalid(String str0,String str1) {
        try{
            if (Integer.parseInt(str0) < Integer.parseInt(str1)){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
         return false;
    }

    private static  boolean isBlank(String str){

        try {
            if (str  == null
                    || str.trim().equals("")
                    ||Integer.parseInt(str) <= 0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 最后出队的人
     * @param n  总数n
     * @param m  出去的人
     */
    public static void queue(int n, int m){
        //定义一个数组，true表示没有出队列的，false表示已经出队列的
        boolean []arr = new boolean[n];
        Arrays.fill(arr, true);

        //指针变量
        int next = 1;

        //数组下标
        int index = 0;

        //剩下的
        int leftCount = n;

        //如果剩下的人数为1人时，停止
        while(leftCount>1){
            if(arr[index] == true){
                if(next == m){
                    arr[index] = false;

                    //剩下的人数减1
                    --leftCount;

                    //下标复位，从1开始报数
                    next = 1;

                    System.out.println("依次出列的人为："+(index+1));
                }else{
                    ++next;
                }
            }

            ++index;
            if(index == n){
                //数组下标复位，从0开始新重遍历
                index = 0;
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i] == true){
                System.out.println("最后出列的人为："+(i+1));
            }
        }
    }

}
