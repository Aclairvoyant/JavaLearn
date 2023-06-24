package com.learn.QQ.QQServer.qqservice.service;

import com.learn.QQ.QQServer.qqcommon.Message;
import com.learn.QQ.QQServer.qqcommon.MessageType;
//import com.learn.QQ.QQServer.qqcommon.User;
import com.learn.QQ.QQClient.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端监听端口，等待客户端的连接
 */
public class QQServer {
    private ServerSocket serverSocket;

    public QQServer() {
        System.out.println("服务端监听中");
        try {
            serverSocket = new ServerSocket(9999);
            //持续监听
            while (true) {
                Socket socket = serverSocket.accept();
                //得到输入流对象
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                //得到输出流
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                //读取客户端发送的User对象
                User user = (User) objectInputStream.readObject();
                //创建Message对象来回复客户端
                Message message = new Message();
                //验证信息
                if (user.getUserId().equals("100") && user.getPasswd().equals("123456")) { //登陆成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //回复客户端
                    objectOutputStream.writeObject(message);
                    //创建线程，保持通讯
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
                    //启动线程
                    serverConnectClientThread.start();
                    //把该线程放入集合，便于管理扩展
                    ManageServerConnectThread.addThread(user.getUserId(), serverConnectClientThread);
                } else {
                    //登陆失败
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    objectOutputStream.writeObject(message);
                    //关闭socket
                    socket.close();
                }

            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //如果服务端退出了while循环，说明不再监听，则关闭
            try {
                //防止空指针异常
                assert serverSocket != null;
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
