package com.alan.demo.utils.Netty.nio;
import java.nio.IntBuffer;
/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/15
 */

public class BasicBuffer {

    public static void main(String[] args) {
        //举例说明Buffer 的使用(简单说明)
        //创建一个Buffer,大小为5,即可以存放5个int

        IntBuffer intBuffer = IntBuffer.allocate(5);

            for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
    }

}
