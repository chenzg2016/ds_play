package com.czg.container;

/**
 * @author chenzg
 * @date 2018.08.29 15:48
 * @description
 **/
public class User implements Comparable<User>{
    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", age=" + age + "]";
    }
    @Override
    public int compareTo(User user) {
        int temp = this.age - user.age;
        return temp == 0 ? this.username.compareTo(user.username) : temp;
    }
}