package com.learn.paramester;

public class polyparamester {
    public static void main(String[] args) {
        Worker tom = new Worker("tom", 2000.0);
        Manage tim = new Manage("tim", 5000.0, 10000.0);
        polyparamester polyparamester = new polyparamester();
        polyparamester.showEmpAnnual(tom);
        polyparamester.showEmpAnnual(tim);

        polyparamester.testWork(tom);
        polyparamester.testWork(tim);

        "hello".equals("abb");
    }

    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e) {
        if (e instanceof Worker) {
            ((Worker) e).work();
        } else if (e instanceof Manage) {
            ((Manage) e).manage();
        } else {
            System.out.println("老板");
        }
    }
}
