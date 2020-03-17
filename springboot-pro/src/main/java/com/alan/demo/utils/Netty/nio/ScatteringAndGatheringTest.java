package com.alan.demo.utils.Netty.nio;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @Description 分撒与聚合
 *
 * Scattering: 将数据写入到Buffer时 ,可以采用buffer数组,一次写入 【分散】
 *
 * Gathering: 从Buffer读取数据时,也可以采用buffer数组,依次读 【聚合】
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/17
 */

public class ScatteringAndGatheringTest {


    public static void main(String[] args) throws IOException {

        //使用 ServerSocketChannel 和 SocketChannel 网络

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        //绑定端口到socket,并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        //创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);


        //等客户端连接(telnet)
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLength = 8;//假定从客户端接收8个字节
        //循环的读取
        while(true){
            int byteRead = 0;
            while (byteRead< messageLength){
                long l = socketChannel.read(byteBuffers);
                //累计读取的字节数
                byteRead+=1;
                System.out.println("byteRead"+byteRead);

                //使用流打印,看看当前的这个buffer的position和limit
                Arrays.asList(byteBuffers)
                        .stream()
                        .map(buffer->"postion="+buffer.position()+",limit="+buffer.limit())
                        .forEach(System.out::println);

            }

            //将所有的buffer进行flip
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            //将数据读出显示到客户端
            long byteWirte = 0;

            while(byteWirte<messageLength){
              long l =   socketChannel.write(byteBuffers);
              byteWirte+=l;
            }


            //将所有的buffer 进行clear 及复位
            Arrays.asList(byteBuffers).forEach(buffer -> {
                buffer.clear();
            });
            System.out.println("byteRead:=" + byteRead + "byteWrite:=" + byteWirte +"," +
                    "messagelength" + messageLength);
        }
    }

}
