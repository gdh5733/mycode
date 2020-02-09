package com.alan.demo.utils.xml.xml;

import java.util.List;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */


public class Student {

    private String name;
    private Integer age;
    private List<String> classList;

    //提供有参构造方法
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //提供无参构造方法
    public Student(){

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

    public List<String> getClassList() {
        return classList;
    }

    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classList=" + String.join(",",classList) +
                '}';
    }
}


