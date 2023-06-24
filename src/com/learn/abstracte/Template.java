package com.learn.abstracte;

abstract class Template {
    public abstract void job();

    public void CurrentTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
