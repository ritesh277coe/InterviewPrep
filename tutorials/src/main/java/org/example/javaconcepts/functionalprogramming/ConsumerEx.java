package org.example.javaconcepts.functionalprogramming;

import java.util.function.Consumer;

//Consumer just consumer and does not return anything
public class ConsumerEx {
    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };

        consumer.accept("Consumer just consumer and does not return anything");
        consumer.accept("Another String");
    }
}
