package org.example.javaconcepts;

import org.example.helpercode.Customer;
import java.util.function.Consumer;
import java.util.function.Function;

/*
Usecase: Need a new class which extends or implements existing class/interface, but only needed EXACTLY ONCE.
 */
public class AnonymousTutorial {
    public static void main(String[] args) {

        //Normal class
        Customer customer = new Customer("a", 1);

        //Anonymous class  extending Customer to String method
        {
            Customer anonymousCustomer = new Customer("a", 2) {
                @Override
                public String toString() {
                    return ("I am anonymousCustomer");
                }
            };


            System.out.println("Normal Customer class " + customer.toString());
            System.out.println("Anonymous Customer class " + anonymousCustomer.toString());
        }


        //Anonymous can be avoided using the functional interface
        {
            Function<Customer, String> function = c -> {
                return "I am anonymousCustomer using functional interface";
            };
            System.out.println("Anonymous Customer class using functional interface " + function.apply(new Customer("a", 2)));
        }

    }
}
