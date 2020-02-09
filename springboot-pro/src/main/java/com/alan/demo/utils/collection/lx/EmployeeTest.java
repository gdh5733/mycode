package com.alan.demo.utils.collection.lx;

import java.util.*;

/**
 * @Description 创建该类的5个对象, 并把这些对象放入 TreeSet 集合中
 * 1) 使Employee 实现Comparable 接口,并按name排序
 * 2) 创建TreeSet 时传入Comparator对象,按生日日期的先手排序
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/23
 */

public class EmployeeTest {

    public static void main(String[] args) {


    }

    /**
     * 问题一:使用自然排序
     */
    private static void sort1() {
        Set set = new HashSet();
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 54, 4));
        Employee e2 = new Employee("zhangxueyou", 55, new MyDate(1987, 54, 4));
        Employee e3 = new Employee("guofucheng", 55, new MyDate(1987, 5, 4));
        Employee e4 = new Employee("liming", 55, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangzhaowei", 55, new MyDate(1978, 12, 4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 问题二: 使用自定义排序
     */
    private static void sort2() {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;


                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    int minusYear = b1.getYear() - b2.getYear();
                    //说明年龄不相同
                    if (minusYear != 0) {
                        return minusYear;
                    }

                    int minusMonth = b1.getMonth() - b2.getMonth();
                    if (minusMonth != 0) {
                        return minusMonth;
                    }

                    return b1.getDay() - b2.getDay();
                }
                return 0;
            }

        });
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 54, 4));
        Employee e2 = new Employee("zhangxueyou", 55, new MyDate(1987, 54, 4));
        Employee e3 = new Employee("guofucheng", 55, new MyDate(1987, 5, 4));
        Employee e4 = new Employee("liming", 55, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangzhaowei", 55, new MyDate(1978, 12, 4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
