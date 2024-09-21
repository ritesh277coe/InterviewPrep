package org.example.javaconcepts.functionalprogramming;

import java.util.function.Function;

public class Callbacks {
    public static void main(String[] args) {
        Function<String, String> function = (s) -> {
            return s.toUpperCase();
        };

        //See that we can use function as well as well defined function toUp if the
        // input args an return type is same as Function interface
        System.out.println(test("ritesh", "singh", function));
        System.out.println(test("ritesh ", "singh", Callbacks::toUp));
    }

    public static String toUp(String s) {
        return s.toUpperCase();
    }
    public static String test(String s1, String s2, Function<String, String> callback) {
        return callback.apply(s1) + callback.apply(s2);
    }
}
