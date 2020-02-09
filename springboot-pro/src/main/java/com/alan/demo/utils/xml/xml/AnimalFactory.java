package com.alan.demo.utils.xml.xml;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/20
 */

public class AnimalFactory {
    public static Animal getAnimal(String type){
        if ("dog".equals(type)){
            return new Dog();
        }else {
            return new Cat();
        }
    }
}
