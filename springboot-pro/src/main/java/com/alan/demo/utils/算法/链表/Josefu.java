package com.alan.demo.utils.算法.链表;

/**
 * @Description 约瑟夫问题
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/1
 */

public class Josefu {

    public static void main(String[] args) {
        //测试一把看看构建环形链表,和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //加入五个小孩
        circleSingleLinkedList.addBoy(5);

        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1, 2, 5);


    }
}

//创建一个环形的单项链表
class CircleSingleLinkedList {
    //创建一个first节点,当前没有编号
    private Boy first = new Boy(-1);

    //添加小孩,构建成一个环形的链表
    public void addBoy(int nums) {
        //nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }

        //辅助指针,帮助构建环形链表
        Boy curBoy = null;


        //使用for循环来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(1);

            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                //构成环
                first.setNext(first);

                //curBoy指向第一个小孩
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        //因为first不能动,因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());

            //说明已经遍历完毕
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }


    /**
     * 根据用过户的输入,计算出出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误,请从新输入");
            return;
        }

        //创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;

        //需求创建一个辅助指针(变量) helper,事先应该指向环形链表的最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前,先让first和helper 移动 k-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        /**
         *当小孩报数时,让first和helper 指针同时移动 m-1次,然后出圈
         * 这里是一个循环操作,直到圈中只有一个节点
         */
        while (true) {
            //说明圈中只有一个节点
            if (helper == first) {
                break;
            }
            //让first和help指针同时的移动countNum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //这时first指向的节点,就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());

            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);

        }
        System.out.printf("最后留在圈中的小孩编号 %d \n", helper.getNo());


    }
}


//创建一个Boy类,表示一个节点
class Boy {
    //编号
    private int no;
    //指向下一个节点,默认null
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
