package jzoffer;

/**
 * @author chenzg
 * @date 9/13/21 11:39 PM
 * @description
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(replaceSpace ("helloworld "));
        System.out.println(replaceSpace1 ("helloworld "));

    }
    public static String replaceSpace (String s) {
        // write code here

        if (s == null || s.length() == 0)
            return "";

        int spaceNum = 0;
        int m = s.length();

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c == ' ')
                spaceNum++;
        }
        //p1指向原字符串末尾
        int p1 = m - 1;
        //p2指向替换之后字符串的末尾，spaceNum为空格数，3是"%20"的长度
        int p2 = p1 + spaceNum * 2;

        char[] tmp = new char[p2+1];
        for (int i = 0; i < s.length(); i++)
            tmp[i] = s.charAt(i);

        //当p1和p2指向同一位置时，说明已经替换完毕
        while (p1 >= 0 && p1 != p2) {
            if (tmp[p1] == ' ') {
                tmp[p2--] = '0';
                tmp[p2--] = '2';
                tmp[p2--] = '%';
            }else {
                tmp[p2--] = tmp[p1];
            }
            p1--;
        }

        return new String(tmp);
    }

    public static String replaceSpace1 (String s) {
        // write code here

        if(null == s) {
            return null;
        }
        String[] strArr = s.split("");
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < strArr.length; i++){
            if ( !" ".equals(strArr[i])) {
                sb.append(strArr[i]);
            }else{
                sb.append("%20");
            }

        }
        return sb.toString();
    }
}
