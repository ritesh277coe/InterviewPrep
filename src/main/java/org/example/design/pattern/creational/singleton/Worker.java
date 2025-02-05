package org.example.design.pattern.creational.singleton;

public class Worker implements Runnable {

    @Override
    public void run() {
        SingletonEx.getInstance().print();

    }
}
