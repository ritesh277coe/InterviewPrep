package org.example.design.pattern.creational.singleton;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0 ; i < 100; i++) {
            Thread thread = new Thread(new Worker());
            thread.start();
        }
        Thread.sleep(1000000);
    }
}
