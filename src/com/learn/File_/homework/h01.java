package com.learn.File_.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class h01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/Users/shenjiadong/Downloads";
        File file = new File(directoryPath);
        if(! file.exists()) {
            //创建
            if(file.mkdirs()) {
                System.out.println("创建成功" + directoryPath);
            }else {
                System.out.println("创建失败" + directoryPath);
            }
        }
        String filePath = directoryPath + "/yes.txt";
        file = new File(filePath);
        if (! file.exists()) {
            if (file.createNewFile()) {
                System.out.println("创建成功" + filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("wasd");
                bufferedWriter.close();
            }else {
                System.out.println("创建失败" + filePath);
            }
        }else {
            System.out.println("文件已存在");
        }
    }
}
