package com.czg.bigdata;

import com.czg.ali.FileWordCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author chenzg
 * @date 8/2/21 2:53 PM
 * @description
 * 例如输入：
 * 统计一篇文章中每个单词出现的次数（文章大小超过10G）
 * If not now when , if not me who?
 * 输出
 * if 2
 * not 2
 * now 1
 * when 1
 * me 1
 * who 1
 * 备注：文章已做过预处理，已将所有标点符号替换为空格。(请使用多线程完成）
 *
 * 下面的例子并未通过.
 */
public class CountWordsInEmail {

// 使用HashMap来存储单词的频率
    Map<String, Integer> wordCount = new HashMap<>();

    public static void main(String[] args) {
        HashMap<String, Integer> map = (HashMap<String, Integer>) new FileWordCount()
                .wordCount("/Users/chenzg/Documents/eg.txt");

        // 自定义排序
        List<Map.Entry<String, Integer>> list = new LinkedList<>();
        list.addAll(map.entrySet());
        list.sort(Comparator.comparingInt(e -> e.getValue()));
        list.forEach(System.out::println);
    }

    /**
     * @param fileName
     */
    public Map<String, Integer> wordCount(String fileName) {
        File file = new File(fileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在!");
        }

        BufferedReader bufr = new BufferedReader(new InputStreamReader(fis));
        String s;
        try {
            while ((s = bufr.readLine()) != null) {
                // 移除字符串的前导空白和后尾部空白
                s = s.trim();
                // 正则表达式：以非字母或者是数字为分隔符，进行分割
                // 英文单词以空格为分隔符，将单词分隔
                String[] str = s.split(" ");
                for (int i = 0; i < str.length; i++) {
                    //并将所有大写字母转换为小写
                    String currentStr = str[i].toLowerCase();
                    // 如果HashMap中已有该值,将值加1
                    if (wordCount.containsKey(currentStr)) {
                        wordCount.put(currentStr, wordCount.get(currentStr) + 1);
                    } else {
                        wordCount.put(currentStr, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        wordCount.remove("");
        return wordCount;
    }
}
