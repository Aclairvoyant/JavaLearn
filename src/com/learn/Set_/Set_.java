package com.learn.Set_;

import java.util.HashSet;
import java.util.Set;

public class Set_ {
    public static void main(String[] args) {
        Set set = new HashSet();
        Employee jack = new Employee("jack", 18);
        Employee john = new Employee("john", 20);
        Employee jack2 = new Employee("jack", 18);
        Employee jack3 = new Employee("jack", 20);

        set.add(jack);
        set.add(john);
        set.add(jack2);
        set.add(jack3);

        System.out.println(set);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
