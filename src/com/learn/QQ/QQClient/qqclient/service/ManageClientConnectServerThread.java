package com.learn.QQ.QQClient.qqclient.service;

import java.util.HashMap;

/**
 * 管理客户端连接到服务端的线程
 */
public class ManageClientConnectServerThread {
    private static HashMap<String, ClientConnectServerThread> hashMap = new HashMap<>();

    //加入到集合
    public static void addThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hashMap.put(userId, clientConnectServerThread);
    }

    //通过id，得到对应线程
    public static ClientConnectServerThread getClientTread(String userId) {
        return hashMap.get(userId);
    }
}
