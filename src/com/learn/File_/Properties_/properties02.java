package com.learn.File_.Properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class properties02 {
    public static void main(String[] args) throws IOException {
        //使用properties类
        Properties properties = new Properties();
        //加载配置文件
        properties.load(new FileReader("src/mysql.properties"));
        //显示k-v到控制台
        properties.list(System.out);
        System.out.println("=====================");
        //根据k 获取v
        String user = properties.getProperty("user");
        System.out.println(user);
    }
}
