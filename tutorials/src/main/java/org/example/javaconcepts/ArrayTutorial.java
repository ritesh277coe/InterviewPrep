package org.example.javaconcepts;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ArrayTutorial {

    public static void main(String[] args) {
//        Customer[] customers = new Customer[10];
//
//        //Functional interface supplier and get function
//        Supplier<Customer> customerSupplier = () -> new Customer("a", new Random().nextInt());
//
//        for (int i = 0; i < 10; i++) {
//            customers[i] = customerSupplier.get();
//        }
//
//        for (Customer customer: customers) {
//            System.out.println(customer.toString());
//        }
//
//        //Functional interface Consumer and accept function
//        Consumer<Customer> consumer = c -> System.out.println(c.toString());
//        consumer.accept(customers[3]);
//
//        Arrays.stream(customers).forEach(consumer);

        List<Integer> l = Arrays.asList(1, 5, 2, 7,3);
        for (Integer x : l) {
            System.out.println(x + " ");
        }
        System.out.println();
        Integer[] arr = l.toArray(new Integer[1]);
        Arrays.sort(arr);
        for (Integer x : arr) {
            System.out.println(x + " ");
        }
        System.out.println();
        Arrays.sort(arr, (Integer a, Integer b) -> {return a.compareTo(b);});
        for (Integer x : arr) {
            System.out.println(x + " ");
        }

        System.out.println();

        l.sort(Comparator.reverseOrder());

    }
}
