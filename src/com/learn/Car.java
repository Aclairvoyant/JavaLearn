package com.learn;

public class Car {
    public String brand = "宝马";
    public int price = 50000;
    public String color = "black";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
