package com.alan.demo.utils.Netty.nio;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description
 * MapperByteBuffer 可让文件直接在内存(堆外内存修改),操作系统不需要在拷贝一次
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/17
 */

public class MapperByteBufferTest {

    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt","rw");

        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();

        /**
         * 参数1:FileChannel.MapMode.READ_WRITE 使用的读写模式
         * 参数2: 0: 可以直接修改起始的位置
         * 参数3: 5: 是映射到内存的大小(不是索引位置),即将1.txt的多少个字节映射到内存
         * 可以直接修改的范围是0-5
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE,0,5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');

        randomAccessFile.close();

        System.out.println("修改成功!");
    }
}
