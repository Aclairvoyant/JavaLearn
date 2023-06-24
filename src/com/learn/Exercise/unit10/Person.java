package com.learn.Exercise.unit10;

public class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        Boat boat = Tools.getBoat();
        boat.work();
    }

    public void common() {
        Horse horse = Tools.getHorse();
        horse.work();
    }
}
