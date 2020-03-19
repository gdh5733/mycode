package com.alan.demo.utils.Netty.nio;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description 编写一个NIO入门案例, 实现服务端和客户端之间的数据简单通信(非阻塞)
 * 目的: 理解NIO非阻塞网络编程机制
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/18
 */

public class NIOServer {


    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel -> ServerSocket

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();


        //得到一个Selecot对象
        Selector selector = Selector.open();


        //绑定一个端口6666,在服务端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));


        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //把 serverSocketChannel 注册到 selector 关心 事件为 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        //循环等待客户端连接
        while (true) {

            //这里我们等待一秒,如果没有事件发生,返回
            if (selector.select(1000) == 0) {//没有事件发生
                System.out.println("服务器等待了1秒,无连接");
                continue;
            }

            //如果返回的>0,就获取到相关的 selectionKey集合
            //1.如果返回的>0,表示已经获取到关注的事件
            //2.selector.selectedKeys() 返回关注事件的集合
            // 通过selectionKeys 反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {

                //获取到SelectionKey
                SelectionKey key = iterator.next();

                //根据key 对应的通道发生的事件做相应处理
                if (key.isAcceptable()) {//如果是OP_ACCPECT,有新的客户端连接
                    //该客户端生成一个 SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    System.out.println("客户端连接成功 生成了一个  socketChannel " + socketChannel.hashCode());


                    //将sockerChannel 设置为非阻塞
                    socketChannel.configureBlocking(false);

                    //将socketchannel 注册到selector,关注事件为OP_READ,同时给socketChannel
                    //关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (key.isReadable()) {//发生 OP_READ
                    //通过key 反向获取到对应channel
                    SocketChannel channel = (SocketChannel) key.channel();

                    //获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("form 客户端" + new String(buffer.array()));
                }
                //手动从集合中移动当前的selectionKey,防止重复操作

                iterator.remove();

            }
        }
    }
}
