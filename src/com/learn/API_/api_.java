package com.learn.API_;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class api_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机地址
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //根据指定主机名获取地址
        InetAddress byName = InetAddress.getByName("MacBook-Pro.local");
        System.out.println(byName);
        //根据域名返回对象
        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println(byName1);
        String hostName = byName1.getHostName();
        System.out.println(hostName);
        String hostAddress = byName1.getHostAddress();
        System.out.println(hostAddress);
    }
}
