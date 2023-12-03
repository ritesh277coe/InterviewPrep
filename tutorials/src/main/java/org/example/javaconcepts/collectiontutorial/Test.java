package org.example.javaconcepts.collectiontutorial;

import org.example.helpercode.Person;

import java.util.ArrayList;
import java.util.List;

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
