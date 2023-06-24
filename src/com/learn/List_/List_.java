package com.learn.List_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("张三");
        list.add("李四");

        list.add(1, "老王");

        for (Object o : list) {
            System.out.println(o);
        }
    }
}
