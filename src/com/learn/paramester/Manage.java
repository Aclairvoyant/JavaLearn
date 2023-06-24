package com.learn.paramester;

public class Manage extends Employee {
    private Double bonus;

    public Manage(String name, Double salary, Double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("管理");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
