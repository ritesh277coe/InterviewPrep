package org.example.javaconcepts.collectiontutorial;

import org.example.helpercode.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return String.valueOf(a) + ":" + name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, name);
    }

    public boolean equals(Object t) {
        if (t == this)
            return true;
        if (t == null || t.getClass() != getClass())
            return false;
        return (((Test)t).a == a  && ((Test)t).name.equals(name));
    }
}
