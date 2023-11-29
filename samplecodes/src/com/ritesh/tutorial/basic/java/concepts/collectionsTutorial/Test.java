package com.ritesh.tutorial.basic.java.concepts.collectionsTutorial;

public class Test {
    int a;
    String name;

    public Test(int a, String name) {
        this.a = a;
        this.name = name;
    }

    public void print() {
        System.out.println(a);
    }

    public boolean equals(Object t) {
        return (((Test)t).a == a  && ((Test)t).name.equals(name));
    }
}
