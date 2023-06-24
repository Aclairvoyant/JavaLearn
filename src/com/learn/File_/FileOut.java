package com.learn.File_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOut {
    public static void main(String[] args) {

    }
    @Test
    public void writeFile() {
        String filePath = "/Users/shenjiadong/Downloads/123.txt";
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath, true)) {
            fileOutputStream.write('a');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
