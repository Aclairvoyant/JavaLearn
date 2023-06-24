package com.learn.List_;

import java.util.Vector;

public class List_Vector {
    public static void main(String[] args) {
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        vector.add(100);
        vector.add(200);

    }
}
