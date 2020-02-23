package com.alan.demo.utils.jvm;

/**
 * @Description 类加载器
 *
 * <p>一：虚拟机自带的加载器
 * 启动类加载器（Bootstrap）C++
 * 扩展类加载器（Extension） Java
 * 应用程序类加载器（AppClassLoader）
 * <p>二: 用户自定义加载器
 * Java.lang.ClassLoader的子类,用户可以定制类的加载方式
 *
 * <p>双亲委派机制
 * 当一个类收到了类加载请求,他首先不会尝试去加载这个类，而是把
 * 这个请求委派给父类去完成,每一个层次类加载器都是如此，因此所有的
 * 加载请求都应该传送到启动类加载其中，只有当父类加载器反馈自己无法完成这个请求的时候
 * （在它的加载路径下没有找到所需要加载的Class），子类加载器才会尝试自己去加载。
 * 采用双亲委派的一个好处是比如加载位于rt.jar包中的类java.lang.Object，不管是那个加载加载
 * 这个类,最终都是委托给顶层的启动类加载器进行加载,这样就保证了使用不同的类加载器最终得到的
 * 都是同样一个Object对象
 *
 *
 * <p> PC 寄存器
 * 每个线程都有一个程序计数器,是线程私有的,就是一个指针,指向方法区中的方法字节码(用来存储指向下一条指令的地址,也即将要执行的指令代码)
 * 由执行引擎读取下一条指令,是一个非常小的内存空间,几乎可以忽略不记.
 * 这块内存的区域很小,它是当前线程所执行的字节码的行号指示器,字节码解释器通过改变这个计数器的值来选取
 * 下一条需要执行的字节码指令。
 * 如果执行的是一个Native方法,那这个计数器是空的。
 * 用以完成分支,循环,跳转,异常处理,线程恢复等基础功能.不会发生内存溢出(OutOfMemory=OOM)错误
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/23
 */

public class MyObeject {


    public static void main(String[] args) {

        //jdk 自带的对像
        Object object = new Object();
        //System.out.println(object.getClass().getClassLoader().getParent().getParent());
        //System.out.println(object.getClass().getClassLoader().getParent());
        System.out.println(object.getClass().getClassLoader());

        //自定义的对象
        MyObeject myObeject = new MyObeject();
        System.out.println(myObeject.getClass().getClassLoader().getParent().getParent());
        System.out.println(myObeject.getClass().getClassLoader().getParent());
        System.out.println(myObeject.getClass().getClassLoader());



    }
}
