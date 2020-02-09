package com.alan.demo.utils.gc.对OOM的理解;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description java.lang.OutOfMemoryError GCOverhead
 * GC回收时间过长会抛出OutOfMemroyError。过长的定义是,超过98%的时间用来做GC
 * 并且回收了不到2%的堆内存,连续多次GC 都只会收了不到2%的极端情况下才会抛出。假如不抛出GC overhead limit 错误会发生什么情况呢?
 * 那就是GC清理的这么点内存很快会再次填满,迫使GC再次执行,这样就形成恶行循环,
 * CPU使用率一直是100%,而GC却没有任何成果
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/1
 */

public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
