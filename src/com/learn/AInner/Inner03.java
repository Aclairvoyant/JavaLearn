package com.learn.AInner;

public class Inner03 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("起床啦");
            }
        });

        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("666");
            }
        });
    }
}

interface Bell {
    void ring();
}

class Cellphone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}

enum BB {

}
