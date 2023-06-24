package com.learn.QQ.QQServer.qqservice.service;

import java.util.HashMap;

/**
 * 管理和客户端通信的线程
 */
public class ManageServerConnectThread {
    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<>();

    public static void addThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hashMap.put(userId, serverConnectClientThread);
    }

    //根据userId 返回 对应线程 对象
    public static ServerConnectClientThread getThread(String userId) {
        return hashMap.get(userId);
    }
}
