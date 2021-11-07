package com.czg.character;

import java.util.regex.Pattern;

/**
 * @author chenzg
 * @date 2019.07.22 17:24
 * @description
 **/
public class RareCharacterUtility1 {

    public static void main(String[] args) {
        //System.out.println(AddressUtil.filterInvalidSymbols("/<>\\ab[]c?&ef\\\\d~!@fgk`”“,$%opq\"\""));
        Pattern CONTAINS_INVALID_SYMBOLS1          = Pattern.compile("((?=[^a-zA-Z0-9])[\\u9FA6-\\u9FEF\\u3400-\\u4DB5\\u20000-\\u2A6D6\\u2A700"
                +"-\\u2B734\\u2B740-\\u2B81D\\u2B820-\\u2CEA1\\u2CEB0-\\u2EBE0\\u2F800-\\u2FA1D"
                + "\\u3007])");

        //final String regex = ".*((?=[^a-zA-Z0-9\\u4E00-\\u9FFF])\\p{sc=Han}).*";
        //Pattern CONTAINS_INVALID_SYMBOLS1          = Pattern.compile(regex);
        String str= "𡏅";
//        System.out.println(stringToUnicode(str));

        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("𡏅").find());  //utf32:213C5 16：\ud844\udfc5
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("㐣返回").find());
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("㐄㐅").find());
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("龭").find());
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("鿋").find());
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("托洞高\uD844\uDFC5染布房22号").find());
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("洞高染aa布房号").find());
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("洞高染布房号").find());
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("洞高染11aa布房号").find());
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("aaa").find());
        System.out.println(CONTAINS_INVALID_SYMBOLS1.matcher("123").find());

    }

}
