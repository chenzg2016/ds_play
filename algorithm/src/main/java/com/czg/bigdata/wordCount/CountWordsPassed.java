package com.czg.bigdata.wordCount;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;

/**
 * @author chenzg
 * @date 8/2/21 3:01 PM
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
 * 实现功能
 * 根据一个英文文档小文件生成大文件；
 *
 * 查询大文件中出现的不同单词；
 *
 * 统计出这些单词出现的次数；
 *
 * 按首字母A-Z顺序输出单词和对应出现次数。
 */
public class CountWordsPassed {

    public static void main(String[] args) throws IOException, InterruptedException
    {
        File file = new File("1.txt");
        System.out.println(file.getAbsolutePath());
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
        FileLock lock = fileChannel.lock(0, file.length(), false);
        MappedByteBuffer mbBuf = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        String str = Charset.forName("UTF-8").decode(mbBuf).toString() + "\r\n";

        //根据1.txt文件生成2.txt（复制1000次1.txt里的内容）
        File file2 = new File("2.txt");
        System.out.println(file2.getAbsolutePath());

        if (file2.exists())
        {
            file2.delete();
        }
        FileOutputStream outputFileStream = new FileOutputStream(file2 , true);
        for (int i = 0; i < 1000; i++)
        {
            outputFileStream.write(str.getBytes("UTF-8"));
        }
        outputFileStream.close();
        lock.release();
        fileChannel.close();

        long start = System.currentTimeMillis();
        DealFileText dft = new DealFileText(file2, 4, 1024 * 1024 * 10); // 文件，线程数，文件分割大小
        dft.doFile();
        long end = System.currentTimeMillis();
        System.out.println("处理文件花费：" + (end - start) / 1000.0 + "秒");
    }

}
