package com.learn.File_.standard;

public class InputAndOutput {
    public static void main(String[] args) {
        // public static final InputStream in = null;
        //编译类型 InputStream
        //运行类型 BufferedInputStream
        System.out.println(System.in.getClass());

        //public static final PrintStream out = null;
        //编译类型 PrintStream
        //运行类型 PrintStream
        System.out.println(System.out.getClass());
    }
}
