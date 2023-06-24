package com.learn.List_;

import java.util.ArrayList;

public class List_ArrayList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        arrayList.add(100);
        arrayList.add(200);
    }
}
