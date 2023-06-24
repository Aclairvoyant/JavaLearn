package com.learn.paramester;

public class Worker extends Employee {
    public Worker(String name, Double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("工人正在工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
