package com.learn.Socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("等待连接中");
        Socket socket = serverSocket.accept();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        String filePath = "/Users/shenjiadong/Downloads/bomb1.png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("收到图片");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        socket.shutdownOutput();
        bufferedWriter.close();
        outputStream.close();

        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
