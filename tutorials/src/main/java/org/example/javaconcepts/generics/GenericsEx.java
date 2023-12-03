package org.example.javaconcepts.generics;

import org.example.helpercode.Customer;
import org.example.helpercode.Person;

import java.io.Serializable;
import java.util.List;

public class GenericsEx {

    public static void main(String[] args) {
    }

    public static <K, V> Integer someGenericFunc(K k, V v) {
        return k.hashCode() + k.hashCode();
    }

    private class SomeGenericClass<T1, T2>{
        public T1 func1( T2 t2, T1 t1)
        {
            return t1;
        }
    }

    //So this class can accept any type that has been extended from person and customer
    //extends can be many just separate by &
    //after extends it can be a class or an interface. Both use extend
    private class SomeGenericClassThatExtends<T1 extends Person & Serializable, T2 extends Customer>{
        public T1 func1( T2 t2, T1 t1)
        {
            return t1;
        }

        //See the ? mark
        public void func2(List<? extends T2> t2, T1 t1)
        {
            return;
        }
    }
}
