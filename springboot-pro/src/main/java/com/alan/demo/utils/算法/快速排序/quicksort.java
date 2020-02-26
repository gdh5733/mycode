package com.alan.demo.utils.算法.快速排序;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * @Description 快速排序
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/19
 */

public class quicksort {


    int startindex;
    int endindex;

    //基准数
    int val;

    int[] arr;


    public static void main(String[] args) {
//        int[] arr = new int[]{4, 4, 6, 5, 3, 8, 1};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

//        int val = searnoRepeat();
//        System.out.println("输出第一个不重复数字的位置:" + val);


        String val = searnoRepeat1();
        System.out.println("输出值为:" + "   " + val);

        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr=" + Arrays.toString(arr));

    }

    /**
     * 快速排序具体方法
     *
     * @param arr
     * @param startindex
     * @param endindex
     * @return
     */
    public static int sortMethod(int[] arr, int startindex, int endindex) {
        int point = startindex;
        int left = startindex;
        int right = endindex;
        // 取第1个位置（也可以选择随机位置）的元素作为基准元素 21.     int pivot = arr[startIndex];
        while (left != right) {
            while (left < right && arr[right] > point) {
                right--;
            }
            while (left < right && arr[left] < point) {
                left++;

            }
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        //pivot 和指针重合点交换 43.
        arr[startindex] = arr[left];
        arr[left] = point;
        return left;

    }


    /**
     * 测试foreach
     */
    public static void testforeach() {
        List<String> list = new ArrayList<>();
        String[] arr = {"12", "123", "456"};
        Map<String, String> map = new HashMap<>();

        for (String str : arr) {
            list.add(str);
        }

        //对当前list中的值不能进行修改 可以借住第二个数据结构 进行数据的更改
        list.forEach(v -> {
            if (v.equals("12") || v.equals("123")) {
                map.put(v, v);
                if (map.containsKey("12")) {
                    map.remove("12");
                }
            }
        });

        map.forEach((k, v) -> {
            System.out.println("键值为:" + k + "值为:" + v);
        });

        for (Map.Entry<String, String> val : map.entrySet()) {
            System.out.println("键:" + val.getKey() + "值为:" + val.getValue());
        }
    }

    /**
     * 测试数组问题
     * 解决字符串数组中查找第一个重复字符串的索引
     */
    public static void testArray() {

        String[] strArr = {"3", "4", "5", "4", "3"};
        //用于存储索引
        int[] index = null;
        List<Integer> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                if (strArr[i] == strArr[j]) {
                    list.add(i);
                    list.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1.compareTo(o2);
                        }
                    });

                }
            }
        }


        System.out.println("数组方法实现第一个重复的索引为:" + list.get(0));

        String str = ArrayUtils.toString(strArr);

        int a = str.indexOf("3");
        int b = str.lastIndexOf("3");
        System.out.println("字符串首次出现的值为:" + a + "字符串最后一次出现的值为:" + b);

    }

    /**
     * 找出字符串中第一个不重复的字符的位置
     * 方法一
     */
    public static int searnoRepeat() {
        String str = "11232359";
        char[] arr = str.toCharArray();
        int length = arr.length;
        int j, i;
        int result = 0;
        for (i = 0; i < length; i++) {
            for (j = 0; j < length; j++) {
                if (i == j) {
                    System.out.println("第二个for" + i);
                    continue;
                }
                if (arr[i] == arr[j]) {
                    System.out.println("第二个forr" + arr[i]);
                    break;
                }
            }
            if (j == length) {
                result = i;
                break;
            }
        }
        if (i == length) {
            result = -1;
        }
        return result;

    }

    /**
     * 找出字符串中第一个不重复的字符的位置  利用了LinkedHashMap的灵活性
     * 注意map 的key 和 value要灵活使用
     * 方法二
     */
    public static String searnoRepeat1() {
        String str = "11232359";
        char[] arr = str.toCharArray();
        String ans = null;
        Map<Character, Integer> sMap = new LinkedHashMap<Character, Integer>();
        for (char c : arr) {
            if (!sMap.containsKey(c)) {
                sMap.put(c, 1);
            } else {
                sMap.put(c, sMap.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> map : sMap.entrySet()) {
            if (map.getValue() == 1) {
                return map.getKey().toString();
            }
        }
        return ans;

    }

    /**
     * 测试break和contine的作用
     */
    public static void testForandBreak() {

        //break结束循环
        for (int i = 0; i < 8; i++) {
            if (i == 4) {
                break;
            }
            System.out.println("break ----i的值为:" + i);
        }

        //contine跳过当前循环
        for (int j = 0; j < 8; j++) {
            if (j == 4) {
                continue;
            }
            System.out.println("break ----j的值为:" + j);
        }

    }


    /**
     * 快速排序
     *
     * @param arr
     * @param left  相同于索引0
     * @param right 相当于索引arr.length -1
     */
    public static void quickSort(int[] arr, int left, int right) {

        //左小标
        int l = left;

        //右下标
        int r = right;


        //pivot 中轴值
        int pivot = arr[(left + right) / 2];

        //临时变量,作为交换时使用
        int temp = 0;

        //while循环的目的是让比pivot 值小放左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }

            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
        }

        //如果 1 == r,必须l++,r--,否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }


    }
}