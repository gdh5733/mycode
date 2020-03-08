package com.alan.demo.utils.spring.Entity;

/**
 * @Description bean的生命周期实验
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/8
 */

public class Person {

    private String id;

    private String sex;

    private String name;


    public Person() {
        System.out.println("One: 创建对象");
    }

    public void init() {
        System.out.println("Three: 初始化");
    }

    @Override
    public String toString() {

        return "Four: 使用";
    }

    public void destory() {
        System.out.println("Five: 销毁");
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        System.out.println("Two: 依赖注入");
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
