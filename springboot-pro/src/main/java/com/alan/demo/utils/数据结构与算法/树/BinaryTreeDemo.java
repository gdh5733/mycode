package com.alan.demo.utils.数据结构与算法.树;
import lombok.Getter;
import lombok.Setter;
/**
 * @Description 二叉树的先序遍历、中序遍历、后序遍历
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/4/13
 */

public class BinaryTreeDemo {

    public static void main(String[] args) {

        //先需要创建一棵二叉树
        BinayTree binayTree = new BinayTree();

        //创建需要的节点
        HerNode root = new HerNode(1, "宋江");
        HerNode node2 = new HerNode(2, "吴用");
        HerNode node3 = new HerNode(3, "卢俊义");
        HerNode node4 = new HerNode(4, "林冲");

        //说明,我们先手动创建该二叉树,后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        binayTree.setRoot(root);

        //测试
        System.out.println("前序遍历");// 1，2，3，4
        binayTree.preOrder();


        //测试
        System.out.println("中序遍历");//2,1,3,4
        binayTree.preOrder();

        //测试
        System.out.println("后续遍历");//2,4,3,1
        binayTree.postOrder();


        //测试前序遍历方式查找
        System.out.println("前序查找遍历方式~~~");
        HerNode resNode = binayTree.preOrderSearch(3);
        if (resNode != null) {
            System.out.printf("找到了,信息为no=%d name=%s", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄", 3);
        }


        //测试中序遍历方式查找
        System.out.println("中序查找遍历方式~~~");
        HerNode resNode2 = binayTree.infixOrderSearch(3);
        if (resNode2 != null) {
            System.out.printf("找到了,信息为no=%d name=%s", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄", 3);
        }


        System.out.println("后续查找遍历方式~~~");
        HerNode resNode3 = binayTree.preOrderSearch(3);
        if (resNode3 != null) {
            System.out.printf("找到了,信息为no=%d name=%s", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄", 3);
        }

    }
}


//定义BinaryTree 二叉树
class BinayTree {

    private HerNode root;

    public void setRoot(HerNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //后续遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }


    //前序遍历查找
    public HerNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }


    //中序遍历查找
    public HerNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后续遍历查找
    public HerNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }

}


//先创建HeroNode 节点
@Setter
@Getter
class HerNode {
    private int no;
    private String name;
    private HerNode left; //默认null
    private HerNode right; //默认null

    public HerNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }

        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }


    /**
     * 中序遍历
     */
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }

        //输出父节点
        System.out.println(this);

        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 先序遍历
     *
     * @param no 查找no
     * @return 如果找到就返回该Node, 如果没有找到返回null
     */
    public HerNode preOrderSearch(int no) {
        System.out.println("开始前序查找遍历");

        //比较当前结点是不是
        if (this.no == no) {
            return this;
        }

        //1.则判断当前结点的左子结点是否为空,如果不为空,则递归前序查找
        //2.如果左递归前序查找,找到结点,则返回
        HerNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中序遍历查找
     *
     * @param no
     * @return
     */
    public HerNode infixOrderSearch(int no) {


        //判断当前结点的左节点是否为空,如果为空,则递归中序查找
        HerNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("开始中序查找遍历");
        //如果找到,则返回,如果没有找到,就和当前结点比较,如果是则返回当前结点
        if (this.no == no) {
            return this;
        }

        //否则继续进行右递归查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 后续遍历查找
     *
     * @param no
     * @return
     */
    public HerNode postOrderSearch(int no) {

        //判断当前结点的左子系欸但那是否为空,如果不为空,则递归后续查找
        HerNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {//说明左子树找到
            return resNode;
        }

        //如果左子树没有找到,则向右子树递归进行后续遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        System.out.println("开始后序查找遍历");
        //如果左右子树都没有找到,就比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}
