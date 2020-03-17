package com.alan.demo.utils.Netty.nio;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Description  使用transferForm 方法实现文件的拷贝
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/16
 */

public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {

        //创建相关的流
        FileInputStream fileInputStream = new FileInputStream("C:\\nioFile\\pic.png");

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\nioFile\\a2.png");


        //获取各个流对应的filechannel
        FileChannel sourch = fileInputStream.getChannel();
        FileChannel destCh = fileOutputStream.getChannel();


        //使用transferForm完成拷贝
        destCh.transferFrom(sourch,0,sourch.size());

        //关闭相关的通道和流
        sourch.close();
        destCh.close();
        fileInputStream.close();
        fileOutputStream.close();



    }
}
