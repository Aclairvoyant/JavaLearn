package com.learn.Generic_;

import java.util.ArrayList;

public class Generic01 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 1800, new MyDate(2008, 12, 12)));
        employees.add(new Employee("tom", 28000, new MyDate(2000, 11, 11)));
        employees.add(new Employee("smith", 380, new MyDate(2002, 10, 10)));
        System.out.println(employees);
        System.out.println("==============================================");
        employees.sort((emp1, emp2) -> {
            if (!(emp1 instanceof Employee && emp2 instanceof Employee))
                return 0;
            int i = emp1.getName().compareTo(emp2.getName());
            if (i != 0) {
                return i;
            }
            return emp1.getBirthday().compareTo(emp2.getBirthday());
        });
        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" + name + ","+ sal + ", " + birthday +'}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}

class MyDate implements Comparable<MyDate> {
    private int month;
    private int day;
    private int year;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" + month + ", " + day + ", " + year + '}';
    }

    @Override
    public int compareTo(MyDate o) {
        int year1 = year - o.year;
        if (year1 != 0) {
            return year1;
        }
        int month1 = month - o.month;
        if (month1 != 0) {
            return month1;
        }
        return day - o.day;
    }
}
