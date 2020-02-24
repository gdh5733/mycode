## GC

````
1.GC 是什么(分代搜集算法)?

次数上频繁收集Young区

次数上较少收集Old区

基本上不动元空间

````

````
2.GC算法
JVM在进行GC时,并非每次都对Eden from To  Old 内存区域一起回收,大部分回收的都是指新生代。
因此GC按照回收的区域又分为了两种类型,一种是普通GC(minor GC)，一种是全局GC(major GC or Full GC)

Minor GC和Full GC的区别

普通GC(minor GC): 只针对新生代区域的GC,只发生在新生代的垃圾收集动作,因为大多数Java对象存活率都不高,
所以Minor GC非常频繁，一般回收速度也比较快。

全局GC(major GC or Full GC)：只发生在老年代的垃圾收集动作,出现了Major GC，经常会伴随至少一次的
Minor GC(但并不是绝对的)。 Major GC速度一般要比Minor GC慢上10倍以上


四大算法
1) 引用计数法
缺点:
  1.每次对对象赋值时均需要引用计数器,且计数器本身也有一定的消耗;
  2.较难处理循环引用
  JVM的实现一般不采取这种方式


2) 复制算法(Copying)
Minor GC会把Eden中的所有活的对象都移到Survivor区域中,如果Survivor区中放不下,那么剩下的
活的对象就被移到Old generation中,也即一旦收集后,Eden是就变成空的了.
当对象在Eden(包括一个Survivor区域,这里假设是from区域)出生后,在经过一次Minor GC之后,如果对象还存活,并且能够被
另外一块Survivor区域所容纳(上面已经假设为from区域,这里应为to区域,即to区域有足够的内存空间来存储Eden和from区域中存活的对象),
则使用复制算法将这些仍然还存活的对象复制到另外一块Survivor区域(即to区域)中,然后清理所使用过的Eden以及Survivor区域(即from区域),
并且将这些对象的年龄设置为1,以后对象在Survivor区每熬过一次 Minor GC,就将对象的年龄+1,当对象的年龄达到某个值时(默认是15岁,通过-XX:MaxTenuringThreshold来设定参数),
这些对象就会成为老年代。

-XX:MaxTenuringThreshold --设置对象在新生代中存活的次数

3) 标记清除(Mark-Sweep)


4) 标记压缩(Mark-Compact)


````
