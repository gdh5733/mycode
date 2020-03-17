package com.alan.demo.utils.Netty.nio;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description 将一个文件中的内容拷贝到另一个文件中
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/16
 */

public class NIOFileChannel03 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\mycode\\springboot-pro\\src\\main\\java\\com\\alan\\demo\\utils\\Netty\\nio\\1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        //循环读取
        while(true){

            //这里有个中重要的操作,一定不要忘了
            //清空 buffer
            byteBuffer.clear();

            int read = fileChannel01.read(byteBuffer);
            //表示读完
            if (read == -1){
                break;
            }

            //将buffer 中的数据写入打扫fileChannel02 --2.txt
            byteBuffer.flip();

            fileChannel02.write(byteBuffer);

            //关闭相关的流
            fileInputStream.close();
            fileOutputStream.close();


        }
    }
}
