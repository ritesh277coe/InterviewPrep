package org.example.design.pattern.creational.singleton;

import java.util.concurrent.ConcurrentHashMap;

public class SingletonEx {
    private static SingletonEx obj = null;
    private static final Object lock = new Object();
    //ConcurrentHashMap<String, String> s = new ConcurrentHashMap<>();

    public void print() {
        System.out.println(this.hashCode());
    }

    public static SingletonEx getInstance() {
        synchronized (lock) {
            if (obj == null) {
                obj = new SingletonEx();
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    private SingletonEx() {

    }
}
