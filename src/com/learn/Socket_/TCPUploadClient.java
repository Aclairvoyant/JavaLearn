package com.learn.Socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPUploadClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取文件的输入流
        String filePath = "src/bomb1.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));

        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedInputStream.close();
        socket.shutdownOutput();//写入结束标志

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
        inputStream.close();

        bufferedOutputStream.close();
        socket.close();
    }
}
