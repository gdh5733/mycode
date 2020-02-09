package com.alan.demo.utils.string.exer;

/**
 * @Description 替换空格
 * <p>
 * 剑指offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/3
 */

public class Solution {


    /**
     * 第一种方法：常规方法。利用String.charAt(i)以及String.valueOf(char).equals(" "
     * 遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {

        int length = str.length();

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < length; i++) {
            char b = str.charAt(i);
            if (String.valueOf(b).equals(" ")) {
                result.append("%20");
            } else {
                result.append(b);
            }
        }
        return result.toString();
    }

    /**
     * 第二种方法：利用API替换掉所用空格，一行代码解决问题
     */
    public static String replaceSpace2(StringBuffer str) {

        return str.toString().replaceAll("\\s", "%20");
    }


}
