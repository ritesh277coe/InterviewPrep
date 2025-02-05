package org.example.design.pattern.creational.factory;

public class CarFactory {
    CarInterface getCar(String carName) {
        if ("BMW".equals(carName)) {
            return new Bmw();
        } else if ("Merc".equals(carName)) {
            return new Merc();
        }
        return null;
    }
}
