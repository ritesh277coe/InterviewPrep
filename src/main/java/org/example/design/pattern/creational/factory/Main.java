package org.example.design.pattern.creational.factory;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        CarInterface bmw = carFactory.getCar("BMW");
        CarInterface merc = carFactory.getCar("Merc");
    }
}
