package com.czg.ali;

public class AliTest {

        public static void main(String args[])
        {
            int i,min,max;
            int Arr[]={12,39,81,5,28,47};  // 声明整数数组A,并赋初值

            min=max=Arr[0];
            System.out.print("数组元素：");
            for(i=0;i<Arr.length;i++)
            {
                System.out.print(Arr[i]+" ");
                if(Arr[i]>max)   // 判断最大值
                    max=Arr[i];
                if(Arr[i]<min)   // 判断最小值
                    min=Arr[i];
            }
            System.out.println();
            System.out.println("最大值："+max); // 输出最大值
            System.out.println("最小值："+min); // 输出最小值
        }

    }
