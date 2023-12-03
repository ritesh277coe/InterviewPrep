package org.example.javaconcepts.threadEx;

import org.example.helpercode.Person;
import org.example.helpercode.PersonDto;

import java.util.concurrent.CompletableFuture;

public class CompleteAbleFutureEx {
    public static CompletableFuture<Person> createPerson() {
        return CompletableFuture.supplyAsync(() ->
                new Person(1, "ram", "singh", "r@b", "M", 20));
    }

    public static void example1() {
        CompletableFuture<Person> personCompletableFuture = createPerson();
        personCompletableFuture
                .thenApplyAsync((person) -> {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return PersonDto.getDtoFromPerson(person);
                })
                .thenApply(personDto -> { System.out.println(Thread.currentThread().getName());
                    return personDto.toString();})
                .thenAccept((s) -> { System.out.println(Thread.currentThread().getName());
                    System.out.println(s);});
    }

    public static void example2() {
        CompletableFuture<Person> personCompletableFuture = createPerson();
        personCompletableFuture
                .thenApply((person) -> {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return PersonDto.getDtoFromPerson(person);
                })
                .thenApplyAsync(personDto -> {
                    System.out.println(Thread.currentThread().getName());
                    return personDto.toString();})
                .thenApply(str -> {
                    System.out.println(Thread.currentThread().getName());
                    return new Person(1, "ram", "singh", "r@b", "M", 20);})
                .thenAccept((s) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(s);});
    }
    
    public static void example3() {
        CompletableFuture<Person> personCompletableFuture = null;
        personCompletableFuture
                .thenApply((person) -> {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return PersonDto.getDtoFromPerson(person);
                })
                .thenApplyAsync(personDto -> {
                    System.out.println(Thread.currentThread().getName());
                    return personDto.toString();})
                .thenApply(str -> {
                    System.out.println(Thread.currentThread().getName());
                    return new Person(1, "ram", "singh", "r@b", "M", 20);})
                .thenAccept((s) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(s);});
        
    }

    public static CompletableFuture<Person> pipeline() {
        CompletableFuture<Person> future = new CompletableFuture<>();
        future.thenApply((person) -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return PersonDto.getDtoFromPerson(person);
            })
                .thenApply(personDto -> {
                    System.out.println(Thread.currentThread().getName());
                    return personDto.toString();})
                .thenApply(str -> {
                    System.out.println(Thread.currentThread().getName());
                    return new Person(1, "ram", "singh", "r@b", "M", 20);})
                .thenAccept((s) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(s);});
        return future;
    }

    /**
     * theApplyAsync will force the work to be done on other thread
     * But thenApply will try to stick to current thread
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //example1();
        //Thread.sleep(1);
        //example2();

        CompletableFuture<Person> future = pipeline();
        Person person = new Person(1, "ram", "singh", "r@b", "M", 20);
        future.complete(person);

    }
}
