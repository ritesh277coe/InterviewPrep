package org.example.design.pattern.creational.builder;

public class Main {
    public static void main(String[] args) {
        TestBuilder.Builder build = TestBuilder.newBuilder();
        TestBuilder ex = build.setA(10).build();
        System.out.println(ex.getA());
    }
}
