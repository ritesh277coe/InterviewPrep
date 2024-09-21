package org.example.javaconcepts;

public interface ITwo {
    default public void test() {
        System.out.println("test2");
    }
    void func2();
}
