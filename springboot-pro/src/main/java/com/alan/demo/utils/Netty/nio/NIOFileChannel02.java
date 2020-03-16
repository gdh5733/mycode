package com.alan.demo.utils.Netty.nio;
import com.sun.org.apache.xpath.internal.operations.String;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description 使用FileChannel将文件中的内容输出到屏幕
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/16
 */

public class NIOFileChannel02 {

    public static void main(String[] args) throws IOException {

        File file = new  File("C:\\学习视频\\file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        //通过fileInputStream 获取对应的FileChannel -> 实际类型 FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();

        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //将通道的数据读入到Buffer中
        fileChannel.read(byteBuffer);

        //将byteBuffer 的字节数据 转成String

        System.out.println(new java.lang.String(byteBuffer.array()));
        fileInputStream.close();

    }


}
