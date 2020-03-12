package com.alan.demo.utils.string.exer;
/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/30
 */

public class StringDemo {


    public static void main(String[] args) {
        reverseTest();
    }


    //测试指定字符串反转
    private static void reverseTest() {
        String str = "abcdefg";
        String strval = reverse(str, 2, 5);

        System.out.println("反转后的值为:" + strval);
    }

    /*
      将一个字符串进行反转。将字符串中指定的部分进行反转,比如abcdefg反转为abfedcg
      方式一
     */
    public static String reverse(String str, int startIndex, int endIndex) {

        if (str != null && str.length() != 0) {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }


    /**
     * 方式二  使用String的拼接
     *
     * @param str        指定的字符串
     * @param startIndex 开始位置
     * @param endIndex   结束位置
     * @return
     */
    public static String reverse1(String str, int startIndex, int endIndex) {

        if (str != null) {
            //第1部分
            String reverseStr = str.substring(0, startIndex);

            //第2部分
            for (int i = endIndex; i >= startIndex; i--) {
                reverseStr += str.charAt(i);
            }
            //第3部分
            reverseStr += str.substring(endIndex + 1);

            return reverseStr;
        }

        return null;
    }

    /**
     * 使用StringBuilder 进行拼接
     *
     * @param str        指定字符串
     * @param startIndex 需要反转的字符串开始位置
     * @param endIndex   需要反转的字符串结束位置
     * @return
     */
    public String reverse2(String str, int startIndex, int endIndex) {

        if (str != null) {
            StringBuilder builder = new StringBuilder();

            //第1部分
            builder.append(str.substring(0, startIndex));

            //第2部分
            for (int i = endIndex; i >= startIndex; i--) {
                builder.append(str.charAt(i));
            }

            //第3部分
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }

        return null;

    }

}
