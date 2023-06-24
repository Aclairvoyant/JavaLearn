package com.learn.File_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class File01 {
    public static void main(String[] args) {

    }

    @Test
    public void create01() throws IOException {
        String filePath = "/Users/shenjiadong/Downloads/new1.txt";
        File file1 = new File(filePath);
        file1.createNewFile();
    }
    @Test
    public void create02() {
        File parentFile = new File("/Users/shenjiadong/Downloads/");
        String fileName = "new2.txt";
        File file2 = new File(parentFile, fileName);
        try {
            file2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void create03() {
        String filePath = "/Users/shenjiadong/Downloads/";
        String fileName = "new3.txt";
        File file3 = new File(filePath, fileName);
        try {
            file3.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
