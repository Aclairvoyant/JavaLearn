package com.learn.Exercise.unit10;

public class Frock {
    private static int currentNum = 100000;

    public Frock() {
    }

    public static int getCurrentNum() {
        return currentNum;
    }

    public static void setCurrentNum(int currentNum) {
        Frock.currentNum = currentNum;
    }

    public static int getNextNum() {
        return currentNum += 100;
    }
}
