package com.learn.QQ.QQServer.qqservice.service;

import com.learn.QQ.QQServer.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 该类的对象和某个客户端保持通讯
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId; //连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() { //发送接收消息
        while (true) {
            System.out.println("服务端与客户端" + userId + "保持通讯");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
