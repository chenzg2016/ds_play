package com.czg.ali;

public class Pass {
//            int x = 5;
//            Pass p = new Pass();
//            p.doStuff(x);
//            System.out.print(" main x = " + x);

//            int x = 4;        System.out.println("value is " + ((x == 4) ? 9:99.9));


//            static int arr[] = new int[10];

//            public static void main(String a[]){
//
////                System.out.println(arr[1]);
//
////                String[] s=new String[10];
////                System.out.println(a.length);
////                System.out.println(a[9]);
//
////                String abc = numAdd("92233720368547758088","2");
//
//                System.out.println(String.valueOf(Long.MAX_VALUE));
//                String abc = numAdd(String.valueOf(Long.MAX_VALUE),"2");
//
//                System.out.println(abc);
//            }
public static void main(String[] args) {
    String abc = numAdd(String.valueOf(Long.MAX_VALUE),"2");
//
                System.out.println(abc);
}


//        void doStuff(int x){
//            System.out.println(" doStuff x = " + x++);
//        }

    public static String numAdd(String a,String b){
        String str="";
        int lenA=a.length();
        int lenB=b.length();
        int maxLen=lenA>lenB?lenA:lenB;
        int minLen=lenA<lenB?lenA:lenB;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<maxLen-minLen;i++){
            sb.append("0");
        }
        if(lenA==minLen){
            a=sb.append(a).toString();
        }
        else{
            b=sb.append(b).toString();
        }

        sb=new StringBuilder();
        int tempA,tempB,result;
        int sc=0;
        for(int i=maxLen-1;i>=0;i--){
            tempA=Integer.valueOf(a.charAt(i)+"");
            tempB=Integer.valueOf(b.charAt(i)+"");
            result=tempA+tempB+sc;
            sc=result/10;
            result=result%10;
            sb.append(result);
        }
        if(sc==1){
            sb.append(sb);
        }
        str=sb.reverse().toString();
        return str;
    }

}
