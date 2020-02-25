package com.alan.demo.utils.算法.选择排序;

import java.util.Arrays;

/**
 * @Description 选择排序
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
