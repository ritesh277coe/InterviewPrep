package org.example.javaconcepts;

import org.example.helpercode.Person;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

        String[] names = {"name1", "name2", "name3", "name4", "name5"};
        Arrays.stream(names)
                .filter(s -> {return s.endsWith("3");})
                .forEach(System.out::println);

        int[] arr1 = {1, 2, 3, 4, 5};
        Arrays.stream(arr1)
                .filter(i -> {return (i > 3);})
                .forEach(System.out::println);

        Person[] people = {
                new Person(1, "a", "A", "a@b", "m", 1),
                new Person(2, "b", "B", "a@b", "f", 2),
        };

        Person[] peopleArr = new Person[10];
        peopleArr[0] = new Person(1, "a", "A", "a@b", "m", 1);
        peopleArr[1] = new Person(2, "b", "A", "a@b", "m", 1);

    }
}
