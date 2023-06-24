package com.learn.Generic_;

import org.junit.jupiter.api.Test;

public class Generic03 {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("string", 100);
    }
}
class Car{
    @Test
    public void run() {
        System.out.println("...");
    }

    public <T, R> void fly(T t, R r) {

    }
}

class Fish <T, R> {
    public void run() {

    }
    public <U, M> void eat(U u, M m) {

    }
}
