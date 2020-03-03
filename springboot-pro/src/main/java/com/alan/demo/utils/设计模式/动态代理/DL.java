package com.alan.demo.utils.设计模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/3
 */


public class DL {


    public IUserService iUserService;

    public DL(IUserService iUserService) {
        this.iUserService = iUserService;
    }


    public IUserService getUser() {

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("在处理业务之前完成一些操作");
                Object obj = method.invoke(iUserService, args);
                return obj;
            }
        };

        ClassLoader loader = iUserService.getClass().getClassLoader();
        Class[] interfaces = iUserService.getClass().getInterfaces();

        IUserService userService = (IUserService) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        return userService;
    }


}


//public class DL implements InvocationHandler {
//
//
//    public  IUserService iUserService;
//
//
//    public DL(IUserService iUserService) {
//        iUserService = iUserService;
//    }
//
//    static {
//
//        ClassLoader loader = iUserService.getClass().getClassLoader();
//        Class[] interfaces = iUserService.getClass().getInterfaces();
//    }
//
//
//    //获取到代理对象
//    public static IUserService getUser() {
//        IUserService userService = (IUserService) Proxy.newProxyInstance(, , DL.class);
//        return userService;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//
//        System.out.println("在查找数据之前做一些事情");
//        Object value = method.invoke(iUserService, args);
//
//        return value;
//    }
//
//}
