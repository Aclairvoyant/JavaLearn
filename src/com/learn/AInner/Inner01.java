package com.learn.AInner;

public class Inner01 {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.method();
    }
}

class Outer01 {
    private int n1 = 10;

    public void method() {
        //基于接口的匿名内部类
//        A a = new A() {
//            @Override
//            public void cry() {
//                System.out.println("111");
//            }
//        };
        A a = () -> System.out.println("111");
        a.cry();

        Father father = new Father("jack") {
            @Override
            public void test() {
                System.out.println("222");
            }
        };
    }
}

interface A {
    void cry();
}

class Father {
    public Father(String name) {
        super();
    }

    public void test() {

    }
}
