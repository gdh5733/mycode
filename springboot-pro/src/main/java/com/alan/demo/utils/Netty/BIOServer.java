package com.alan.demo.utils.Netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description BIO服务器
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/13
 */

public class BIOServer {


    public static void main(String[] args) throws IOException {

        //线程池机制


        //思路
        //1.创建一个线程池
        //2.如果有客户端连接,就创建一个线程,与之通讯(单独写一个方法)


        ExecutorService executor = Executors.newCachedThreadPool();

        //创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");

        while (true) {

            //监听,等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }


    }

    //编写一个handler方法 和客户端通讯
    public static void handler(Socket socket) {

        byte[] bytes = new byte[1024];

        //通过socket 获取输入流
        try {
            InputStream inputStream = socket.getInputStream();

            //循环的读取客户端发送的数据
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    //输出客户端发送的数据
                    System.out.println(new String(bytes, 0, read));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
