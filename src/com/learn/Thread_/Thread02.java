package com.learn.Thread_;

public class Thread02 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        Thread thread = new Thread(t2);
        thread.start();

        Tiger tiger = new Tiger();
        Proxy proxy = new Proxy(tiger);
        proxy.run();
    }
}
class Animal { }
class Tiger extends Animal implements Runnable {

    @Override
    public void run() {
        System.out.println("ajajaj");
    }
}

class Proxy implements Runnable {
    private Runnable target;

    @Override
    public void run() {
        if (target != null) {
           target.run();
        }
    } //把proxy类当作Thread

    public Proxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();
    }

    public void start0() {
        run();
    }
}
class T2 implements Runnable {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hi" + (++times));
            if (times == 10) {
                break;
            }
        }
    }
}
