package org.example.javaconcepts.functionalprogramming;

import java.util.function.Predicate;

//Takes arg an return boolean
public class PredicateEx {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> {
            return s.equals("IamPredicate");
        };

        System.out.println(predicate.test("IamPredicate"));
        System.out.println(predicate.test("IamNotPredicate"));

    }
}
