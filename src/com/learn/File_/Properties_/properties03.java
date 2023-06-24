package com.learn.File_.Properties_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class properties03 {
    public static void main(String[] args) throws IOException {
        //创建properties文件以及修改
        Properties properties = new Properties();
        //创建
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "汤姆");//中文是unicode
        properties.setProperty("user", "tom");//修改替换user
        //存储
        properties.store(new FileOutputStream("src/mysql2.properties"), null);

    }
}
