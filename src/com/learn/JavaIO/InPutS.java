package com.learn.JavaIO;

import java.io.FileInputStream;
import java.io.IOException;

public class InPutS {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("JavaIO/text.txt")) {
            byte[] bytes = new byte[inputStream.available()];
            System.out.println(inputStream.read(bytes));
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
