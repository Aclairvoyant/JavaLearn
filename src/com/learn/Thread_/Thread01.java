package com.learn.Thread_;

public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();//启动线程
        //cat.run();
    }
}

class Cat extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("123");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
