package com.alan.demo.utils.数据结构与算法.稀疏数组;

/**
 * @Description 稀疏数组
 * 二维数组  转 稀疏数组的思路
 * 1.遍历 原始的二位数组,得到有效数据的个数sum
 * 2.根据sum就可以创建稀疏数组 sparseArr int[sum+1][3]
 * 3.将二维数组的有效数据存入到 稀疏数组
 * <p>
 * 稀疏数组  转原始的二维数组的思路
 * 1.读取稀疏数组的第一行,根据第一行的数据,创建原始的二位数组,比如上面的chessArr2 = int[11][12]
 * 2.在读取稀疏数组后几行的数据,并赋给 原始的二位数组 即可
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/31
 */

public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0:表示没有棋子, 1.表示 黑子  2.表示蓝子
        int chessArr1[][] = new int[11][11];

        //在棋盘中设置两个棋子
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始二位数组
        System.out.println("原始的二位数组:");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            //每打印完一行换行
            System.out.println();
        }

        //将二位数组转稀疏数组
        //1.先遍历二位数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        /**
         * 稀疏数组样板
         *
         *     行   列   值
         *    row  col  val
         * 0   11  11    2
         * 1   1   2     1
         * 2   2   3     2
         */
        int spareseArr[][] = new int[sum + 1][3];

        //给稀疏数组赋值
        spareseArr[0][0] = 11;
        spareseArr[0][1] = 11;
        spareseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    spareseArr[count][0] = i;
                    spareseArr[count][1] = j;
                    spareseArr[count][2] = chessArr1[i][j];
                }

            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~");
        for (int i = 0; i < spareseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", spareseArr[i][0], spareseArr[i][1], spareseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组 --> 恢复成 原始的二位数组
        //1. 先读取稀疏数组的第一行,根据第一行的数据,创建原始的二维数组
        int chessArr2[][] = new int[spareseArr[0][0]][spareseArr[0][1]];


        for (int i = 1; i < spareseArr.length; i++) {
            chessArr2[spareseArr[i][0]][spareseArr[i][1]] = spareseArr[i][2];
        }

        //输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            //每打印完一行换行
            System.out.println();
        }
    }


}
