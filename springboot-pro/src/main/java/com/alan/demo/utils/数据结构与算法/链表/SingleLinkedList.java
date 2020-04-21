package com.alan.demo.utils.数据结构与算法.链表;

import java.util.Stack;

import static com.alan.demo.utils.数据结构与算法.链表.SingleLinkedListDemo.*;

/**
 * @Description 简单的链表实现  (头节点不能动)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/31
 */

public class SingleLinkedList {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");

        //创建要给链表
        //加入
        SingleLinkedListDemo singleLinkedListDemo = new SingleLinkedListDemo();
        singleLinkedListDemo.add(hero2);
        singleLinkedListDemo.add(hero1);
        singleLinkedListDemo.add(hero3);

        //测试单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedListDemo.list();
        System.out.println("反转单链表~~");
        reversetList(singleLinkedListDemo.getHead());
        singleLinkedListDemo.list();

        System.out.println("逆序打印单链表,没有改变链表的结构~~");
        reversePrint(singleLinkedListDemo.getHead());

        //显示一把
        System.out.println("修改之前的情况~~");
        singleLinkedListDemo.list();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedListDemo.update(newHeroNode);

        //显示
        System.out.println("修改后的链表情况~~");
        singleLinkedListDemo.list();

        //删除一个节点
        singleLinkedListDemo.del(1);
        System.out.println("删除后的链表情况~~");
        singleLinkedListDemo.list();


        //测试一下 求单链表中有效节点的个数
        System.out.println("有效的节点个数" + getLength(singleLinkedListDemo.getHead()));

        HeroNode res = findLastIndexNode(singleLinkedListDemo.getHead(), 1);
        System.out.printf("倒数第一个数据为 %s\n", res);
    }

}

//定义SingleLinkedList 管理我们的 英雄

class SingleLinkedListDemo {
    //先初始化一个头节点吗,头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");


    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单项链表
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next 指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能动,因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后,将temp后移
            temp = temp.next;
        }

        //当退出while循环时,temp就指向了链表的最后
        //将最后这个节点的next 指向新的节点
        temp.next = heroNode;
    }

    //显示链表【遍历】
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点,不能动,因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移,一定要小心
            temp = temp.next;
        }
    }


    /**
     * 修改节点信息,根据no编号
     */
    public void update(HeroNode newheroNode) {
        //定义一个辅助变量
        HeroNode temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //已经遍历完该链表
                break;
            }
            if (temp.no == newheroNode.no) {
                //找到
                flag = true;
                break;
            }
            //指针继续移动
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newheroNode.name;
            temp.nickname = newheroNode.nickname;
        } else {
            System.out.printf("没有找到编号 %d 的节点,不能修改\n", newheroNode.no);
        }
    }


    /**
     * 删除节点
     * 思路
     * 1.head 不能动,因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2.说明我们在比较时,是temp.next.no 和需要删除节点的no比较
     */
    public void del(int no) {
        HeroNode temp = head;

        //标志是否找到待删除的节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //已经到链表的最后了
                break;
            }
            //注意这个位置 是找到前一个 因为不是双向链表
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag) {
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到该编号 %d\n", no);
        }

    }


    /**
     * 获取到单链表节点的个数(如果是带头节点的链表,需要不统计头节点)
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        //空链表
        if (head.next == null) {
            return 0;
        }
        int length = 0;

        //定义一个辅助的变量 这里没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;//遍历
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第k个节点【新浪面试题】
     * 1.编写一个方法,接收到head节点,同时接收一个index
     * 2.index 表示是倒数第index个节点
     * 3.先把链表从头到尾遍历,得到链表的总的长度
     * 4.得到size后 , 我们从链表的第一个开始遍历(size-index)个,就可以得到
     * 如果找到了,则返回该节点,否者返回null
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空 ,返回null
        if (head.next == null) {
            return null;
        }
        //第一个遍历得到的链表的长度(节点个数)
        int size = getLength(head);

        //第二次遍历 size-index 位置,就是我们倒数的第K个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义一个辅助变量  for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 将单链表反转
     * <p>
     * 思路: 创建一个新的表头  ,在原来的链表上面 创建两个辅助指针 一次遍历原链表,将原链表的节点放到第二个节点
     */
    public static void reversetList(HeroNode head) {
        //如果当前链表为空,或者只有一个节点,无序反转,直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针(变量),帮助我们遍历原来的来链表
        HeroNode cur = head.next;

        //指向当前节点[cur]的下一个节点
        HeroNode next = null;

        //新建链表的头节点
        HeroNode reverseHead = new HeroNode(0, "", "");

        //遍历原来的链表,并从头到尾遍历原来的链表,每遍历一个节点,就将其取出,并放在新的链表reverseHead的最前端
        //动脑筋
        while (cur != null) {
            //先暂时保存当前节点的下一个节点 因为后面需要使用
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            //将cur 连接到新的链表上
            reverseHead.next = cur;
            //让cur后后移
            cur = next;
        }

        //将head.next 指向reverseHead.next,实现单链表的反转
        head.next = reverseHead.next;

    }

    /**
     * 从尾到头打印链表
     * 思路
     * 1.上面的题的要求就是逆序打印链表
     * 2.方式一: 先将单链表进行反转,然后在遍历即可,这样做的问题是会破坏原来的单链表的结构,不建议
     * 方式二: 可以利用栈这个数据结构,将各个节点的压入到栈中,然后利用栈的先进后出的特点,就实现了逆序打印的效果
     */

    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            //空链表 不能打印
            return;
        }

        //创建一个栈,将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈中
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //将栈中的节点进行打印 pop出栈
        while (stack.size() > 0) {
            //先进后出
            System.out.println(stack.pop());
        }
    }


}

//定义HeroNode,每个HeriNode 对象就是一个节点
class HeroNode {

    public int no;
    public String name;
    public String nickname;
    //指向下一个节点
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便 重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}

