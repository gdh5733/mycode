package com.alan.demo.utils.Netty.nio;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * @Description 使用FileChannel 将字符串写入到文件中
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/15
 */

public class NIOFileChannel01 {

    public static void main(String[] args) throws IOException {
        String str = "Hello nio";


        //创建一个输出流->Channel
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\学习视频\\file01.txt");

        //通过fileOutputStream 获取 对应的FileChannel
        //这个fileChannel 真实 类型是 FileChannel()
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个缓冲区 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将str 放入 byteBuffer
        byteBuffer.put(str.getBytes());

        //对byteBuffer 进行flip
        byteBuffer.flip();

        //将byteBuffer 数据写入到fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();

    }
}
