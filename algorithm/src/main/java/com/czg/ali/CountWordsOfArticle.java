//package com.czg.ali;
//
///**
// * @author chenzg
// * @date 2019.04.12 20:49
// * @description
// **/
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.MappedByteBuffer;
//import java.nio.channels.FileChannel;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.stream.Collectors;
//
//public class CountWordsOfArticle {
//    public void countWordsOfArticle(String fileName, int arraySize) throws IOException {
//        File file = new File(fileName);
//        if (!file.exists()) {
//            System.out.println("该文件不存在");
//            return;
//        }
//        MappedBiggerFileReader reader = new MappedBiggerFileReader(fileName, arraySize);
//        while (reader.read() != -1) {
//            wordCount(reader);
//        }
//    }
//
//    private static void wordCount(MappedBiggerFileReader reader) throws IOException {
//        Map<String, Integer> map = new ConcurrentHashMap<>();
//        BufferedReader in = new BufferedReader(new InputStreamReader(reader));
//        StringBuffer buffer = new StringBuffer();
//        String line = " ";
//        while ((line = in.readLine()) != null) {
//            buffer.append(line);
//        }
//        String request = buffer.toString();
//
//        String[] strs = request.split(line);
//        for (int i = 0; i < strs.length; i++) {
//            if (map.containsKey(strs[i].toLowerCase())) {
//                map.put(strs[i].toLowerCase(), map.get(strs[i].toLowerCase()) + 1);
//            } else {
//                map.put(strs[i].toLowerCase(), 1);
//            }
//        }
//        List<Map.Entry<String, Integer>> result = map.entrySet().stream()
//                .sorted(new Comparator<Map.Entry<String, Integer>>() {
//                    @Override
//                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                        return o2.getValue().compareTo(o1.getValue());
//                    }
//                }).collect(Collectors.toList());
//        result.forEach(item -> {
//            System.out.println(item.getKey() + " " + item.getValue());
//        });
//    }
//
//    public class MappedBiggerFileReader extends InputStream{
//        private MappedByteBuffer[] mappedBufArray;
//        private int count = 0;
//        private int number;
//        private FileInputStream fileIn;
//        private long fileLength;
//        private int arraySize;
//        private byte[] array;
//
//        public MappedBiggerFileReader(String fileName, int arraySize) throws IOException {
//            this.fileIn = new FileInputStream(fileName);
//            FileChannel fileChannel = fileIn.getChannel();
//            this.fileLength = fileChannel.size();
//            this.number = (int) Math.ceil((double) fileLength / (double) Integer.MAX_VALUE);
//            this.mappedBufArray = new MappedByteBuffer[number];// 内存文件映射数组
//            long preLength = 0;
//            long regionSize = (long) Integer.MAX_VALUE;// 映射区域的大小
//            for (int i = 0; i < number; i++) {// 将文件的连续区域映射到内存文件映射数组中
//                if (fileLength - preLength < (long) Integer.MAX_VALUE) {
//                    regionSize = fileLength - preLength;// 最后一片区域的大小
//                }
//                mappedBufArray[i] = fileChannel.map(FileChannel.MapMode.READ_ONLY, preLength, regionSize);
//                preLength += regionSize;// 下一片区域的开始
//            }
//            this.arraySize = arraySize;
//        }
//
//        public int read() throws IOException {
//            if (count >= number) {
//                return -1;
//            }
//            int limit = mappedBufArray[count].limit();
//            int position = mappedBufArray[count].position();
//            if (limit - position > arraySize) {
//                array = new byte[arraySize];
//                mappedBufArray[count].get(array);
//                return arraySize;
//            } else {// 本内存文件映射最后一次读取数据
//                array = new byte[limit - position];
//                mappedBufArray[count].get(array);
//                if (count < number) {
//                    count++;// 转换到下一个内存文件映射
//                }
//                return limit - position;
//            }
//        }
//
//        public void close() throws IOException {
//            fileIn.close();
//            array = null;
//        }
//
//        public byte[] getArray() {
//            return array;
//        }
//
//        public long getFileLength() {
//            return fileLength;
//        }
//    }
//}