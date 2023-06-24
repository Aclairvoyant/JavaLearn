package com.learn.Exercise.E01;

public class E01 {
    public static void main(String[] args) {
        Person[] person = new Person[3];

        person[0] = new Person("1", 18, "t");
        person[1] = new Person("2", 21, "tt");
        person[2] = new Person("3", 20, "ttt");

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }

        Person temp = null;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - 1 - i; j++) {
                if (person[j].getAge() < person[j + 1].getAge()) {
                    temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
    }
}
