package com.learn.MInner;

public class Inner04 {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        //outer01.hi();

        //外部其他类访问成员内部类
        Outer01.MInner01 mInner01 = outer01.new MInner01();

        Outer01.MInner01 mInner01Instance = new Outer01().getMInner01Instance();
    }
}

class Outer01 {//外部类
    private int n1 = 100;
    public String name;

    public class MInner01 {//成员内部类,可添加访问修饰符

        public void say() {
            System.out.println("hi");
        }
    }

    public void hi() {
        MInner01 mInner01 = new MInner01();
        mInner01.say();
    }

    public MInner01 getMInner01Instance() {
        return new MInner01();
    }
}
