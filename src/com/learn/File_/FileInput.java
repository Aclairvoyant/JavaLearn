package com.learn.File_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInput {
    public static void main(String[] args) {

    }

    @Test
    public void FileInput01() throws IOException {
        String filePath = "/Users/shenjiadong/Downloads/hello.txt";
        int readData = 0;
        byte[] buf = new byte[8];
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            while ((fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readData));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
