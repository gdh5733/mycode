package com.alan.demo.utils.数据结构与算法.选择排序;
import java.util.Arrays;

/**
 * @Description 选择排序
 * 基本思想:
 * 如果有n个元素需要排序,那么首先从N个元素中找到最小的那个元素与第0位置上的元素
 * 交换(说明一点如果没有比原本在第0位置上的元素小的就不用交换了,后面的同样是),
 * 然后再从剩下的N-1个元素中找到最小元素与第一个位置上的元素交换,之后再从剩下的N-2
 * 个元素中找到最小的元素与第2个元素交换,....直到所有元素都排序好(也就是直到从剩下的2个元素中
 * 找到最小的元素与第N-2位置上的元素交换)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/25
 */

public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        sort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 选择排序
     * 注意推导过程
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        //在推到过程中,我们发现了规律，因此,可以使用for来解决
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                //这个位置可以控制升序还是降序
                if (min < arr[j]) {
                    //重置min
                    min = arr[j];

                    //重置minIndex
                    minIndex = j;
                }
            }
            // 将最小值,放在arr[0],即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
