package com.learn.File_;

import java.io.*;

public class ObjectOutStream_ {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/shenjiadong/Downloads/hello.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(100);
        oos.writeChar('a');
        oos.writeBoolean(true);
        oos.writeObject(new Dog("sam", 100));

        oos.close();
    }
}

class Dog implements Serializable {
    String name;
    int price;
    @Serial
    private static final long serialVersionUID = 1L; //序列化版本号，可以提高兼容性
    public Dog(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
