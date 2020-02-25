package com.alan.demo.utils.算法.插入排序;

import java.util.Arrays;

/**
 * @Description 插入排序
 * <p>
 * 推导过程+ 实际代码
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/25
 */

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
    }

    //插入排序 实际代码
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];

            //即arr[1]的前面这个数的下标
            int insertIndex = i - 1;


            //给insertVal 找到插入的位置
            //说明
            //1.insertIndex >= 0保证在给insertVal 找插入位置,不越界
            //2.insertVal < arr[insertIndex] 待插入的数,还没有找到插入的位置
            //3.就需要将arr[insertIndex]后移

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            //当退出while循环时,说明插入的位置找到,insertIndex + 1

            arr[insertIndex + 1] = insertVal;
            System.out.println("第 "+i+" 轮插入");
            System.out.println(Arrays.toString(arr));
        }


    }


    //插入排序 推到过程
    public static void tdInsertSort(int[] arr) {

        //使用逐步推到的方式来讲解,便于理解
        //第一轮{101,34,119,1}; => {34,101,119,1}


        //{101,34,119,1}; =>{101,101,119,1}
        //定义待插入的数
        int insertVal = arr[1];

        //即arr[1]的前面这个数的下标
        int insertIndex = 1 - 1;


        //给insertVal 找到插入的位置
        //说明
        //1.insertIndex >= 0保证在给insertVal 找插入位置,不越界
        //2.insertVal < arr[insertIndex] 待插入的数,还没有找到插入的位置
        //3.就需要将arr[insertIndex]后移

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        //当退出while循环时,说明插入的位置找到,insertIndex + 1

        arr[insertIndex + 1] = insertVal;
        System.out.println("第一轮插入");
        System.out.println(Arrays.toString(arr));


        //第2轮
        insertVal = arr[2];
        insertIndex = 2 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第2轮插入");
        System.out.println(Arrays.toString(arr));


        //第3轮
        insertVal = arr[3];
        insertIndex = 3 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第3轮插入");
        System.out.println(Arrays.toString(arr));
    }
}
