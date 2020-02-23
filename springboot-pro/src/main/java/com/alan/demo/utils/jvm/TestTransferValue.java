package com.alan.demo.utils.jvm;


/**
 * @Description 基本数据类型传值     引用数据类型传地址   String 比较特殊 常量池中有就是使用  没有在常量池中新创建
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/23
 */

public class TestTransferValue {
    private void changeValue1(int age) {
        age = 25;
    }

    private void changeValue2(Person person) {
        person.setName("xxx");
    }

    private void changeValue3(String str) {
        str = "xxx";
    }

    public static void main(String[] args) {

        TestTransferValue test = new TestTransferValue();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age---" + age);


        Person person = new Person("alan");
        test.changeValue2(person);
        System.out.println("personName-----" + person.getName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("string-----" + str);
    }
}
