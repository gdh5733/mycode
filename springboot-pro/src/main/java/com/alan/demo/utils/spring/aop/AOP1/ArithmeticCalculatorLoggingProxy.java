//package com.alan.demo.utils.spring.aop.AOP1;
//
//import com.alan.demo.utils.spring.aop.AOP1.ArithmeticCalculator;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
///**
// * @Description 使用动态代理实现AOP
// * @Author gaodehan
// * @Version V1.0.0
// * @Since 1.0
// * @Date 2020/1/28
// */
//
//public class ArithmeticCalculatorLoggingProxy {
//
//    //要代理的对象
//    private ArithmeticCalculator target;
//
//    //通过构造方法传入具体要代理的对象 即 初始化要代理的对象
//    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
//        this.target = target;
//    }
//
//    public ArithmeticCalculator getLoggingProxy() {
//        ArithmeticCalculator proxy = null;
//        //代理对象由哪一个类加载器负责加载
//        ClassLoader loader = target.getClass().getClassLoader();
//
//        //代理对象的类型,即其中有那些方法
//        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
//
//        //代理主要接口 (当调用代理对象其中的方法时,该执行的代码)
//        /**
//         * proxy: 正在返回的那个代理对象,一般情况下,在invoke 方法中都不使用该方法
//         * method: 正在被调用的方法
//         * args: 调用方法时,传入的参数
//         */
//        InvocationHandler h = new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//                Object result = null;
//                System.out.println("方法执行开始.....");
//
//                try {
//                    //前置通知
//                    result = method.invoke(target, args);
//                    //返回通知,可以访问到方法的返回返回值
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    //异常通知,可以访问到方法出现的异常
//                }
//
//                //后置通知,因为方法可能会出现异常,所以访问不到方法的返回值
//
//                System.out.println("方法执行结束....");
//                return result;
//
//            }
//        };
//        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
//
//        return proxy;
//
//    }
//}
