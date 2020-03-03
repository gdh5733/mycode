package com.alan.demo.utils.设计模式.动态代理;

public class Main {

    public static void main(String[] args) {
        IUserService iUserService = new UserServiceImpl();

        //初始化我写的代理
        DL dl = new DL(iUserService);

        //获取到代理
        IUserService userService = dl.getUser();


        //通过代理来进行业务逻辑的处理
        String service = userService.findUser("1");
        System.out.println(service);

        System.out.println("程序结束");
    }
}
