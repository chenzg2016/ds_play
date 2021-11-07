package com.understandjvm.gk;

import lombok.Builder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author chenzg
 * @date 11/7/21 11:50 AM
 * @description
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class helloClass = new HelloClassLoader().findClass("Hello");
            Object obj = helloClass.newInstance();
            Method method = helloClass.getMethod("hello");
            method.invoke(obj);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {

        String filePath = "file:///Users/chenzg/Desktop/JavaDevStudy/" + name + ".xlass";
        System.out.println(filePath);
        byte[] xLassBytes = null;
        Path path = null;
        try {
            path = Paths.get(new URI(filePath));
            xLassBytes = Files.readAllBytes(path);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        byte[] repairedClassBytes = repairBytes(xLassBytes);

        Class clazz = defineClass(name, repairedClassBytes, 0, repairedClassBytes.length);
        return clazz;

    }

    /**
     * byte[] 转为16进制String
     */
    public static byte[] repairBytes(byte[] b) {
        byte[] repairedClassBytes = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            int rb = 255 - b[i];
            repairedClassBytes[i] = Integer.valueOf(rb).byteValue();
        }
        return repairedClassBytes;
    }

}
