package com.learn.QQ.QQClient.qqclient.service;

import com.learn.QQ.QQClient.qqcommon.Message;
import com.learn.QQ.QQClient.qqcommon.MessageType;
//import com.learn.QQ.QQClient.qqcommon.User;
import com.learn.QQ.QQServer.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 用户登陆和用户注册功能
 */
public class UserClientService {
    private User user = new User();
    private Socket socket;

    //根据用户名和密码发送到服务端判断
    public boolean checkUser(String userId, String passwd) {
        boolean b = false;
        //创建User对象
        user.setUserId(userId);
        user.setPasswd(passwd);
        //连接到服务端并发送
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //得到ObjectOutPutStream对象
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(user); //发送User对象

            //读取从服务端发送的Message对象
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) objectInputStream.readObject();
            if (message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) { //登陆成功
                //创建一个和服务器保持通讯的线程 -> 创建连接线程类
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动客户端
                clientConnectServerThread.start();
                //将线程放入集合，便于管理扩展
                ManageClientConnectServerThread.addThread(userId, clientConnectServerThread);
                b = true;
            } else {
                //启动失败，不启动线程，并关闭socket
                socket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return b;
    }
}
