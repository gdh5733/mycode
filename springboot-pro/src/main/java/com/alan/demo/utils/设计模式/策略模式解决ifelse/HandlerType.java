package com.alan.demo.utils.设计模式.策略模式解决ifelse;


import java.lang.annotation.*;

/**
 * 自定义注解 @HandlerType：
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {

    String value();

}
