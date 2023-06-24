package com.learn.File_.Print_;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.print("hello");
        out.write("123".getBytes());
        out.close();

        System.setOut(new PrintStream("/Users/shenjiadong/Downloads/123.txt"));
        System.out.println("hello hello");

    }
}
