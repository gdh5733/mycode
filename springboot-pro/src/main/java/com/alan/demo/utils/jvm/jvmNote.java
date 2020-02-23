package com.alan.demo.utils.jvm;

/**
 * @Description 主题JVM
 * <p>
 * 1.JVM系统架构图
 * <p> 2.类加载器
 * System.out.println(myObeject.getClass().getClassLoader().getParent().getParent());
 * System.out.println(myObeject.getClass().getClassLoader().getParent());
 * System.out.println(myObeject.getClass().getClassLoader());
 * <p>
 * 2.1 有哪几种类加载器
 * 2.2 双亲委派
 * 2.3 沙箱安全机制
 *
 * <p> 3.Native
 * 3.1 native是一个关键字
 * 3.2 声明有,实现无,why?
 * 4.PC寄存器
 * 4.1 记录了方法之间的调用和执行情况,类似排版值日表
 * 用来存储一条指令的地址,也即将要执行的指令代码
 * 它是当前线程所执行的字节码的行号指示器
 *
 * <p> 5.方法区
 * 供各线程共享的运行时内存区域,它存储了每一个类的结构信息
 * 例如运行时常量池(Runtime Constant Pool) 字段和方法数据 构造函数和普通方法的字节码内容。
 * 上面讲的时规范,在不同虚拟机里头实现是不一样的,最典型的就是永久代(PermGen space)和元空间(Metaspace)
 * <p>
 * 注: 实例变量存在堆内存中,和方法区无关
 * 5.1 它存储了每一个类的结构信息
 * 5.2 方法区是规范,在不同虚拟机里头实现是不一样的，最典型的就是永久代(PermGen space)和元空间(Metaspace)。
 *
 *
 * <p> 6.Stack
 * <p>
 * 栈管运行,堆管存储
 * <p>
 * 栈也叫栈内存,主管Java程序的运行,是在线程创建时创建,它的生命期是跟随线程的生命期，
 * 线程结束栈内存也就释放,对于栈来说不存在垃圾回收问题,只要线程一结束该栈就over,生命周期和线程
 * 一致,是线程私有的。8种基本类型的变量+对象的引用变量+实例方法都是在函数的栈内存中分配。
 * <p>
 * 6.1 栈存储什么?
 * 栈帧中主要保存3 类数据:
 * <p>
 * 本地变量(Local Variables)： 输入参数和输出参数以及方法内的变量;
 * <p>
 * 栈操作(Operand Stack) :记录出栈,入栈的操作;
 * <p>
 * 栈帧数据(Frame Data): 包括类文件,方法等等。
 * <p>
 * 6.2 栈保存那些东东?
 * 8中基本类型的变量+实例方法都是在函数的栈内存中分配。
 * <p>
 * 6.3 Exception in thread "main" java.lang.stackOverflowError
 *
 *
 * <p>堆
 * Eden满了,开启
 * GC = YGC = 轻GC

 * Eden基本全部清空

 * S0 = from
 * S1 = to

 * from区和to区,他们的位置和名分,不是固定的,每次GC后会交换
 * GC之后有交换,谁空谁是to

 * Old养老区,满了,开启
 * Full GC = FGC

 * Full GC 多次,发现养老区没办法腾出来

 * OOM

 * MinorGC的过程(复制->清空->互换)
 * 1：eden,SurvivorFrom 复制到SurvivorTo,年龄+1
 * 首先,当Eden区满的时候会触发第一次GC,把还活着的对象拷贝到SurvivorFrom区,当Eden区再次
 * 触发GC的时候会扫描Eden区和From区域,对这两个区域进行回收,经过这次回收后还存活的对象,则直接复制到To区域
 * (如果有对象的年龄已经达到了老年的标准,则赋值到老年代区),同时把这些对象的年龄+1
 *
 *
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/23
 */

public class jvmNote {

    public static void main(String[] args) {

        try {
            System.out.println("sdfas");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
