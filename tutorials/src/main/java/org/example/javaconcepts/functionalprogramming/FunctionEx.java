package org.example.javaconcepts.functionalprogramming;

import java.util.function.*;

public class FunctionEx {

    public static void main (String[] args) {
        //Function takes 1 arg and returns 1 arg
        //Below s will be input arg of Function.apply and
        //lines between {} is implementation of Function.apply
        Function<String, String> calcHashCode = (s) -> {
            int hash = s.hashCode();
            return String.valueOf(hash);
        };
        System.out.println(calcHashCode.apply("test"));

        Function<String, String> concat = calcHashCode.andThen(calcHashCode);
        System.out.println(concat.apply("test"));

        //BiFunction
        BiFunction<String, String, String> biFunction = (a, b) -> {
            return a+b;
        };
        System.out.println(biFunction.apply("ritesh", "singh"));
    }
}
