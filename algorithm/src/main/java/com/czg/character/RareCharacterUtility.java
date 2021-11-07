package com.czg.character;

/**
 * @author chenzg
 * @date 2019.07.22 17:24
 * @description
 **/
public class RareCharacterUtility {

    public static boolean containsUserDefinedUnicode(String string) {
        if (string == null) {
            throw new NullPointerException("Stirng must be non-null");
        }
        int[] code = toCodePointArray(string);
        //  U+E000..U+F8FF
        //4E00-9FA5
        for (int c : code) {
            if (c >= '\u4E00' && c <= '\u9FA5') {
                return true;
            }

        }
        return false;
    }

    static int[] toCodePointArray(String str) {
        int len = str.length();
        int[] acp = new int[str.codePointCount(0, len)];

        for (int i = 0, j = 0; i < len; i = str.offsetByCodePoints(i, 1)) {
            acp[j++] = str.codePointAt(i);
        }
        return acp;
    }

    static String toHex(int[] chars) {
        String r = "[";
        for (int i=0; i<chars.length; i++) {
            if (r.length() > 1) {
                r += ",";
            }
            r += Integer.toHexString(chars[i]);
        }
        r += "]";
        return r;
    }

    public static void main(String[] argu) {
        String rr = ("\u5f20\ue0bf\uD86C\uDE70\uD840\uDC10\uD86D\uDF44\uD87E\uDCAC\u9fc6");
        System.out.println("Unicode = " + toHex(toCodePointArray(rr)));

        boolean r = (containsUserDefinedUnicode("𡏅"));
        System.out.println("Test result = " + r + " should be true");
    }

}
