package com.alan.demo.ioc.xml.ann;

import com.alan.demo.ioc.xml.xml.Animal;
import com.alan.demo.ioc.xml.xml.Cat;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Description 像容器中注入方法二  实现Factorybean接口
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/21
 */

@Component
public class MyCat implements FactoryBean<Animal> {
    @Override
    public Animal getObject() throws Exception {
        return new Cat();
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }
}
