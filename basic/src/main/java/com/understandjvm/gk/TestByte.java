package com.understandjvm.gk;

/**
 * @author chenzg
 * @date 11/7/21 8:36 PM
 * @description
 */
public class TestByte {

    public static void main(String[] args) {
        String s = "Helloppppppppvvvvvvvvvvvvv";
        byte[] b = s.getBytes();
        byte[] c = reduceBytes(b);
        byte[] repairB = repairBytes(c);
        String t = new String(repairB);
        System.out.println(t);

    }

    /**
     * byte[] 转为16进制String
     */
    public static byte[] reduceBytes(byte[] b) {

        byte[] repairedClassBytes = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            int rb = b[i] - 255;
            repairedClassBytes[i] = Integer.valueOf(rb).byteValue();
        }
        return repairedClassBytes;
    }

    /**
     * byte[] 转为16进制String
     */
    public static byte[] repairBytes(byte[] b) {

        byte[] repairedClassBytes = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            int rb = b[i] + 255;
            repairedClassBytes[i] = Integer.valueOf(rb).byteValue();
        }
        return repairedClassBytes;
    }

    /**
     * byte[] 转为16进制String
     */
    public static byte[] repairBytes2(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            int rb = b[i] + 255;
            ret += Integer.valueOf(rb).byteValue();
        }
        return ret.getBytes();
    }
}
