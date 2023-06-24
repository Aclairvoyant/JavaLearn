package com.learn.File_.Properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class properties01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/mysql.properties"));
        String line = "";
        while((line = bufferedReader.readLine()) != null) {
            String[] split = line.split("=");
            System.out.println(split[0] + split[1]);
        }
        bufferedReader.close();
    }
}
