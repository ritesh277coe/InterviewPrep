package org.example.javaconcepts.functionalprogramming;

import java.util.List;
import java.util.function.Supplier;

public class SupplierEx {
    public static void main(String[] args) {
        Supplier<List<String>> supplier = () -> {
            List<String> list = List.of(
                    "ritesh",
                    "singh"
                    );
            return list;
        };

        List<String> list = supplier.get();
        list.stream().forEach((s) -> {
            System.out.println(s);
        });
    }
}
