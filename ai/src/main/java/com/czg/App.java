package com.czg;

import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String question;
        while (true) {
            question = scanner.next();
            question = question.replace("吗", "");
            question = question.replace("我", "我也");
            question = question.replace("？", "!");
            System.out.println(question);
        }
    }
}
