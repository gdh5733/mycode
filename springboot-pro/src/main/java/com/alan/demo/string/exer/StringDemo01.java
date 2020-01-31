package com.alan.demo.string.exer;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/30
 */

public class StringDemo01 {

    public static void main(String[] args) {

    }

    /**
     * 获取一个字符串在另一个字符串中出现的次数
     * 比如: 获取"ab" 在 "abkkcadkabkebfkabkskab" 中出现的次数
     * <p>
     * 获取subStr在mainStr中出现的次数
     *
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr, String subStr) {
        int mainlength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainlength >= subLength) {
            //方式一
//            while ((index = mainStr.indexOf(subStr)) != -1) {
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }

            //方式二: 对方式一的改进
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLength;
            }
            return count;
        } else {
            return 0;
        }
    }
}
