package com.learn.override;

public class dog extends Animal {
    @Override
    public void cry() {
        super.cry();
        System.out.println("小狗叫");
    }

    public String m1() {
        return null;
    }
}
