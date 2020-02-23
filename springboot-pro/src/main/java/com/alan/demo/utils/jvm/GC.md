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
2) 复制算法(Copying)
3) 标记清除(Mark-Sweep)
4) 标记压缩(Mark-Compact)


````
