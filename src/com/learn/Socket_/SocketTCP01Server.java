package com.learn.Socket_;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //创建 9999 端口监听
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待中...");
        //等待连接
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }
        //关闭
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
