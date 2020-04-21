package com.alan.demo.utils.数据结构与算法.冒泡排序;

/**
 * @Description 测试break
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/4/13
 */

public class testBreak {


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("开始循环" + i);

            for (int j = 3; j > 0; j--) {
                System.out.println("最内层循环退出了" + j + "次!");
                break;
            }
            System.out.println("最外层循环" + i + "次");
        }
    }
}
