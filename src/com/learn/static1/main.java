package com.learn.static1;

public class main {
    public static void main(String[] args) {
        System.out.println(a.getS());
    }
}

class a {
    private static int s = 10;

    public static int getS() {
        return s;
    }

    public static void setS(int s) {
        a.s = s;
    }
}
