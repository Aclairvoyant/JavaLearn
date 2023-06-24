package com.learn.single;

public class SingleTon01 {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);
    }
}

//饿汉式，存在浪费资源
class GirlFriend {
    private String name;

    private static GirlFriend gf = new GirlFriend("lala");//内部直接创建对象

    private GirlFriend(String name) {
        this.name = name;
    }//私有化

    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}

