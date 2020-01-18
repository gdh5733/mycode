package com.alan.demo.utils.算法.链表;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/1
 */

public class DoubleLinkedList {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //创建一个双向链表
        DoubleLinkedListDemo doubleLinkedList = new DoubleLinkedListDemo();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);


        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();


        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表的情况~~");
        doubleLinkedList.list();
    }
}


//创建一个双向链表的类
class DoubleLinkedListDemo {

    //先初始化一个头节点,头节点不要动,不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    //显示链表【遍历】
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //因为头节点,不能动,因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);

            //将temp后移,一定要小心
            temp = temp.next;
        }
    }

    //添加一个节点到双向链表的最后
    public void add(HeroNode2 heroNode) {

        //因为head节点不能动,因此我们需要要一个辅助遍历temp
        HeroNode2 temp = head;

        //遍历链表,找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后,将temp后移
            temp = temp.next;
        }
        //当退出while循环时,temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;

    }


    /**
     * 修改双向链表节点信息,根据no编号
     */
    public void update(HeroNode2 newheroNode) {
        //定义一个辅助变量
        HeroNode2 temp = head.next;
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
     * 从双向链表中删除一个节点
     * 说明
     * 1.对于双向链表,我们可以直接找到要删除的这个节点
     * 2.找到后,自我删除金即可
     */
    public void del(int no) {

        //判断当前链表是否为空
        //空链表
        if (head.next == null) {
            System.out.println("链表为空,无法删除");
            return;
        }
        //辅助变量(指针)
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                //找到待删除的节点
                flag = true;
                break;
            }
            //temp后移，遍历
            temp = temp.next;
        }

        //判断flag
        if (flag) {
            // 找到 可以删除
            //temp.next = temp.next.next【单向链表】
            temp.pre.next = temp.next;
            //如果是最后一个节点,就不需要执行下面一句话,否则出现空指针
            temp.next.pre = temp.pre;
        } else {
            System.out.printf("要删除的%d 节点不存在\n", no);
        }

    }


}

//定义HerNode2,每个HerNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;

    //指向下一个节点,默认为null
    public HeroNode2 next;

    //指向前一个节点,默认为null
    public HeroNode2 pre;

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
