package com.learn.Socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//字符流
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待连接中");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        //使用字符流，使用InputStreamReader 将 inputStream 转成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client 字符流");
        bufferedWriter.newLine();//插入结束标志
        bufferedWriter.flush();//刷新

        socket.shutdownOutput();
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
