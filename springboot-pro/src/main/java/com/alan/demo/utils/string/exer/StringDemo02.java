package com.alan.demo.utils.string.exer;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/30
 */

public class StringDemo02 {

    public static void main(String[] args) {
        String strval = getMaxSameString("abcwerthelloyuiodef", "cvhellobnm");
        System.out.println("找出匹配的最长字符串为:" + strval);
    }

    /**
     * 获取两个字符串中最大相同子串。比如
     * str1 = "abcwerthelloyuiodef"; str2 = "cvhellobnm"
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String getMaxSameString(String str1, String str2) {

        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;

        int length = minStr.length();


        for (int i = 0; i < length; i++) {
            for (int x = 0, y = length - i; y <= length; x++, y++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr)) {
                    return subStr;
                }
            }
        }

        return null;
    }
}
