package com.learn.Array;

import java.util.Arrays;
import java.util.Comparator;

public class Array01 {
    public static void main(String[] args) {
        Integer[] arr = {1, 20, 7, 67, 57, 44, 30};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i1 - i2;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
