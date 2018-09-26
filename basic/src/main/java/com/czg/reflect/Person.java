package com.czg.reflect;

import java.io.Serializable;

/**
 * @author chenzg
 * @date 2018.08.26 12:51
 * @description
 **/
public class Person implements Serializable {

    private String name;

    private int age;

    private String cardNum;

    private String phone;

    private char sex;

    private String company;

    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {

        this.sex = sex;
        System.out.println("设置性别:"+sex);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    Person(String name){
        System.out.println("(默认)的构造方法 s = " + name);
    }

    //无参构造方法
    public Person(){
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    //有多个参数的构造方法
    public Person(String name ,int age){
        System.out.println("姓名："+name+"年龄："+ age);//这的执行效率有问题，以后解决。
    }

    //受保护的构造方法
    protected Person(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private Person(int age){
        System.out.println("私有的构造方法   年龄："+ age);
    }

    @Override
    public String toString(){
        return "name:" + name
                + "cardNum:" + cardNum
                + "phone:" + phone
                + "sex:" + sex
                + "company:" + company
                + "address:" + address;
    }


}
