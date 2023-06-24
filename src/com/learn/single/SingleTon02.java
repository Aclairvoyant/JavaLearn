package com.learn.single;

public class SingleTon02 {
    public static void main(String[] args) {
        Cat cat = Cat.getInstance();
        System.out.println(cat);
    }
}

//懒汉式，存在线程安全
class Cat {
    private String name;
    private static Cat cat;

    private Cat(String name) {
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("小可爱");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

}
