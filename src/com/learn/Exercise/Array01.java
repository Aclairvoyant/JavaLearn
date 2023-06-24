package com.learn.Exercise;

import java.util.ArrayList;

public class Array01 {
    public static void main(String[] args) {
        test test1 = new test("新冠确诊病例超千万，数百万印度教徒赴恒河圣浴引民众担忧");
        test test2 = new test("男子突然想起两个月前钓的鱼还在网兜里，捞起一看赶紧放生");

        ArrayList arrayList = new ArrayList();
        arrayList.add(test1);
        arrayList.add(test2);

        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            test tests = (test) arrayList.get(i);
            System.out.println(dealWith(tests.getTitle()));
        }

        //Collections.reverse(arrayList);
        for (Object o : arrayList) {
            System.out.println(o);
        }
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(dealWith(test.getTitle()));
//        }

    }

    public static String dealWith(String title) {
        if (title == null) {
            return "";
        } else if (title.length() > 15) {
            return title.substring(0, 15) + "...";
        } else {
            return title;
        }
    }
}

class test {
    private String title;
    private String text;

    public test(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'';
    }
}
