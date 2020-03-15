package com.alan.demo.utils.collection;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/23
 */

public class TreeSetTest {

    /**
     * 1.向TreeSet中添加的数据,要求是相同类的对象
     * 2.两种排序方式: 自然排序(实现Comparable接口 和定制排序(Comparator))
     * 3.自然排序中,比较两个对象是否相同的标准为: compareTo()返回0,不再是equals()
     * 4.定制排序中,比较两个对象是否相同的标准为: compare()返回0,不再是equals()
     */

    public static void main(String[] args) {

    }

    public void test1() {

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                if (o1 instanceof User && o2 instanceof User) {
                    Integer u1 = ((User) o1).getAge();
                    Integer u2 = ((User) o2).getAge();
                    return Integer.compare(u1, u2);
                } else {
                    throw new RuntimeException();
                }

            }
        };

        //使用自定义排序
        TreeSet set = new TreeSet(comparator);
    }
}
