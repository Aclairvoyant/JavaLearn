package com.learn.abstracte;

public class AA extends Template {
    @Override
    public void job() {
        long sum = 0;
        for (long i = 0; i < 1000000000; i++) {
            sum += i;
        }
    }
}
