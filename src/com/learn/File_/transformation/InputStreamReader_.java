package com.learn.File_.transformation;

import java.io.*;

public class InputStreamReader_ { //将字节流转换成字符流，解决乱码问题
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/shenjiadong/Downloads/123.txt";
        //把FileInputStream 转换成 InputStreamReader
        //指定编码gbk
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //把InputStreamReader 传入 BufferedReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        //套娃
        BufferedReader gbk = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));

        //读取
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭外层流
        bufferedReader.close();
    }
}
