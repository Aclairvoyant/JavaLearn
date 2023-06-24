package com.learn.Collection_;

import java.util.ArrayList;

public class Collection_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add(10);
        System.out.println(arrayList);

        arrayList.remove(Integer.valueOf(10));
        System.out.println(arrayList);

        System.out.println(arrayList.contains("jack"));

        System.out.println(arrayList.size());

    }
}
