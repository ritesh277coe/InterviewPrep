package org.example.javaconcepts;

public interface IOne {
    default public void test() {
        System.out.println("test1");
    }
    void func1();
}
