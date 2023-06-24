package com.learn.Generic_;

public class Generic02 {
    public static void main(String[] args) {

    }
}

interface IUsb<U, R> {
    int n = 10;
    R get(U u);

    void hello(R r);

    void run(R r1, R r2, U u1, U u2);

    default R method(U u) {
        return null;
    }
}

interface IA extends IUsb<String, Double> {

}

class AA implements IA {
    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hello(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}
