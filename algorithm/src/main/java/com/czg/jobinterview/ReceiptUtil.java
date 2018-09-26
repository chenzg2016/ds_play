package com.czg.jobinterview;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 发票大写工具类
 * @author chenzg
 * @date 2018.09.21 21:20
 * @description
 **/
public class ReceiptUtil {
    private static HashMap<String,String> ChineseCharacter = new HashMap();
    private static HashMap<String,String> MetricUnit = new HashMap();

    static{

        ChineseCharacter.put("0","零");
       ChineseCharacter.put("1","壹");
       ChineseCharacter.put("2","贰");
       ChineseCharacter.put("3","叁");
       ChineseCharacter.put("4","肆");
       ChineseCharacter.put("5","伍");
       ChineseCharacter.put("6","陆");
       ChineseCharacter.put("7","柒");
       ChineseCharacter.put("8","捌");
       ChineseCharacter.put("9","玖");
       MetricUnit.put("1","拾");
       MetricUnit.put("2","佰");
       MetricUnit.put("3","仟");
       MetricUnit.put("4","万");
       MetricUnit.put("5","拾");
       MetricUnit.put("6","佰");
       MetricUnit.put("7","仟");
       MetricUnit.put("8","亿");
       MetricUnit.put("9","拾");
       MetricUnit.put("10","佰");
       MetricUnit.put("11","仟");
        MetricUnit.put("12","万");
    }

    public static String convert(double d){
        String result = null;
        String str = String.valueOf(new BigDecimal(Double.toString(d)));
        String[] numArr = str.split("\\.");
        String strBeforeDot = null;
        String strAfterDot = null;
        if (numArr.length > 1){
             strAfterDot = converWitoutUnit(numArr[1]);
        }
        strBeforeDot = converWitUnit(numArr[0]);
        if (strAfterDot != null){
            result = strBeforeDot + "点" + strAfterDot;
        }
        return result;
    }

    public static String converWitoutUnit(String strAfterDot){
        String[] strings = strAfterDot.split("");
        StringBuffer sb = new StringBuffer("");
        for (int i=0;i < strings.length;i++) {
            String num = ChineseCharacter.get(strings[i]);
            sb.append(num);
        }
        return sb.toString();
    }

    public static String converWitUnit(String strBeforeDot){
        String reverseStr = new StringBuilder(strBeforeDot).reverse().toString();
        String[] strings = reverseStr.split("");
        StringBuffer sb = new StringBuffer("");
        for (int i=0;i < strings.length;i++) {
            if (i == 0){
                String num = ChineseCharacter.get(strings[i]);
                sb.append(num);
            }else {
                String num  = ChineseCharacter.get(strings[i]);
                String unit = MetricUnit.get(i+"");
                sb.append(unit).append(num);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(convert(1234567890123.77));
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String out = convert(Double.valueOf(scanner.next()));
            System.out.println(out);
        }
    }
}
