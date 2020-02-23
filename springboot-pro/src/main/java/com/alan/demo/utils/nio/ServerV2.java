package com.alan.demo.utils.nio;

import com.rabbitmq.client.impl.AMQImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description NIO
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/21
 */

public class ServerV2 {
    public static void main(String[] args) throws IOException {

        ExecutorService threadPoolExecutor = Executors.newCachedThreadPool();

        //绑定端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        System.out.println("NIO启动8080");

        Selector selector = Selector.open();

        while (true) {
            //获取新连接
            SocketChannel newSocketConnection = serverSocketChannel.accept();
            newSocketConnection.configureBlocking(false);//显示配置为非阻塞

            newSocketConnection.register(selector, SelectionKey.OP_READ); //注册一个事件通知机制，READ

            selector.select();
            Set<SelectionKey> eventkeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = eventkeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey event = iterator.next();
                if (event.isReadable()) {
                    SocketChannel socketConnection = (SocketChannel) event.channel();
                    threadPoolExecutor.submit(() -> {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        try {
                            socketConnection.read(byteBuffer);//【非阻塞】
                            byteBuffer.flip();//转换为读模式
                            System.out.println(new String(byteBuffer.array()));

                            // TODO: 2020/2/21  业务操作 数据库操作 接口调用

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    });

                }
            }

            //应不应该 把请求交给线程去处理? ---
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024); //申请内存存储 从操作系统中读取到的数据
            newSocketConnection.read(byteBuffer);


            byteBuffer.flip(); //转换为读模式
            System.out.println(new String(byteBuffer.array()));

        }
    }

}
