package com.alan.demo.utils.collection;


import java.util.Objects;

/**
 * @Description 自定义javabean
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/20
 */


public class User implements Comparable {

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
        User user = (User) o;
        return name.equals(user.name) &&
                age.equals(user.age);
    }

    //
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    //按照姓名从大到小排列,年龄从小到大
    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            int compare = -this.name.compareTo(user.name);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.age, user.age);
            }
        } else {
            throw new RuntimeException("输入类型不匹配");
        }
    }
}
