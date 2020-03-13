package com.alan.demo.utils.collection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.*;

/**
 * @Description 1.Set 接口的框架
 * <p>
 * ----Collection接口 单列集合,用来存储一个一个的对象
 * ----Set接口 存储无序的,不可重复的数据 --> 高中讲的集合
 * ---HashSet 作为Set接口的主要实现类;线程不安全的;可以存储null值
 * ---LinkedHashSet：作为HashSet的子类:遍历其内部数据时,可以按照添加的顺序
 * ---TreeSet：可以按照添加对象的指定属性,进行排序
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/21
 */

public class HashSetTest {

    /**
     * 一 .Set:
     * 1.存储无序 -->
     * 2.不可重复的数据   保证添加的元素通过hashCode 和 equal来实现  如下User 应该重写hashCode 和 equals方法,即相同元素只能添加一个
     * <p>
     * 二.添加元素的过程: 以HashSet为例:
     * 我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法,计算元素a的哈希值,此哈希值接着通过某种算法计算出在HashSet底层数组中
     * 存放位置(即为: 索引的位置),判断数组此位置上是否已经有元素:
     * 如果此位置上没有其他元素,则元素a添加成功。
     * 如果此位置上有其他元素b(或以链表形式存在多个元素),则比较元素a与元素b的hash值:
     * 如果hash值不相同,则元素a添加成功。
     * 如果hash值相同,进而需要调用y元素a所在类的equals()方法:
     * equals()返回true,元素a添加失败
     * equals()返回false,则元素a添加成功。
     * <p>
     * 对于添加添加成功的情况而言: 元素a 与已经存在指定索引位置上数据以链表的方式存储。
     * jdk 7: 元素a方法数组中,指向原来的元素。(7上)
     * jdk 8: 原来的元素在数组中,指向元素a(8下)
     */

    public void test1() {
        Set set = new HashSet<>();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom", 12));
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * LinkHashSet底层是用的数组+链表
     * 但和HashSet不同的是多了一层链表能够准确找到每个添加的元素
     */
    public void testLinkHashSet() {
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(789);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String val = (String) iterator.next();
            System.out.println(val);
        }
    }

    @Setter
    @Getter
    @ToString
    class User implements Comparable {

        private String name;

        private Integer age;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {

            System.out.println("equals.....");
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            com.alan.demo.utils.collection.User user = (com.alan.demo.utils.collection.User) o;
            return name.equals(user.getName()) &&
                    age.equals(user.getAge());
        }

        //
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }


        //按照姓名从大到小排列,年龄从小到大
        @Override
        public int compareTo(Object o) {
            if (o instanceof com.alan.demo.utils.collection.User) {
                com.alan.demo.utils.collection.User user = (com.alan.demo.utils.collection.User) o;
                int compare = -this.name.compareTo(user.getName());
                if (compare != 0) {
                    return compare;
                } else {
                    return Integer.compare(this.age, user.getAge());
                }
            } else {
                throw new RuntimeException("输入类型不匹配");
            }
        }
    }
}



