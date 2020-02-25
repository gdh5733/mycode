package com.alan.demo.utils.算法.冒泡排序;

import com.alan.demo.utils.DateUtils;

import java.util.Date;

/**
 * @Description 冒泡排序
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/25
 */

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            //生成一个【0，8000000) 的随机数
            arr[i] = (int) (Math.random() * 8000000);
        }

        String currtime = DateUtils.getDate(new Date());
        System.out.println("排序前的时间为: " + currtime);
        bubbleSort(arr);
        String beforetime = DateUtils.getDate(new Date());
        System.out.println("排序后的时间为: " + beforetime);
    }


    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] arr) {


        //为了容易理解,以下展示冒泡排序的演变过程

        //第一趟排序,就是将最大的数派排在最后
        //临时变量
        int temp = 0;
        //标识变量,表示是否进行过交换
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大,则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第" + (i + 1) + "趟排序后的数组");
//            System.out.println(Arrays.toString(arr));

            if (!flag) {
                break;
            } else {
                //重置flag!!!,进行下次判断
                flag = false;
            }
        }
    }
}
