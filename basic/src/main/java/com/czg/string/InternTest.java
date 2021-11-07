package com.czg.string;

/**
 * @author chenzg
 * @date 10/29/21 9:48 AM
 * @description
 */
public class InternTest {

    public static void main(String[] args) {


        String s = new String("1");
        s.intern();//调用此方法之前，字符串常量池中已经存在了“1”
        String s2 = "1";
        System.out.println(s == s2);//jdk6:false jdk7/8:false

        String s3 = new String("1") + new String("1");//s3变量记录的地址为：new String("11")，堆中。
        //执行完上一行代码以后，字符串常量池中，不存在“11”！！！
        s3.intern();//在字符串常量池中生成“11”。jdk6中，永久代中创建了一个新的对象“11”，也就有了新的地址。
        //jdk7/jdk8中，此时常量中并没有创建“11”，而是添加一个指向堆空间中new String("11")的地址
        String s4 = "11";//s4变量记录的地址：使用的是上一行代码执行时，在字符串常量池中生成的“11”的地址
        System.out.println(s3 == s4);//jdk6:false jdk7/8:true

    }
}
