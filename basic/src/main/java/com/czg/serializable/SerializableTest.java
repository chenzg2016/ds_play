package com.czg.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author chenzg
 * @date 8/2/21 4:58 PM
 * @description
 */
public class SerializableTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos =new FileOutputStream("game-person.info");
        ObjectOutputStream oos =new ObjectOutputStream(fos);
        GamePerson personIn =new GamePerson();
        personIn.setName("abcde");
        personIn.setLevel(1);
        personIn.setForceValue(2);
        personIn.setDefenseValue(3);
        personIn.setMoney(200);
        // 通过在序列化之前，使用类变量直接赋值，可知
        // 一个静态变量不管是否被transient修饰，均不能被序列化），反序列化后类中static型变量username的值为当前JVM中
        // 对应static变量的值，这个值是JVM中的不是反序列化得出的
        GamePerson.level =400;
        oos.writeObject(personIn);
        oos.flush();
        oos.close();

        FileInputStream fis =new FileInputStream("game-person.info");
        ObjectInputStream ois =new ObjectInputStream(fis);
        GamePerson personOut = (GamePerson) ois.readObject();
        System.out.println("personOut.getName:"+personOut.getName());
        System.out.println("personOut.getLevel:"+personOut.getLevel());
        System.out.println("personOut.getForceValue:"+personOut.getForceValue());
        System.out.println("personOut.getDefenseValue:"+personOut.getDefenseValue());
        System.out.println("personOut.getMoney:"+personOut.getMoney());
    }



}
