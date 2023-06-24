package com.learn.Socket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //连接主机的 9999 端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket" + socket.getClass());
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //写入数据到数据通道
        outputStream.write("hello, server".getBytes());
        //关闭流对象和socket
        outputStream.close();
        socket.close();
    }
}
