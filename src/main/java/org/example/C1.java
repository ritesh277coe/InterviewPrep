package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public final class C1 implements Comparable<C1> {
    private final String s;
    private int val;

    public C1(int val, String s) {
        this.val = val;
        this.s = s;
    }

    public C1(String s) {
        this.s = s;
    }

    @Override
    public int compareTo(C1 o) {
      return this.val - o.val;
    }

    @Override
    public String toString() {
        return this.s + "_" + String.valueOf(val);
    }


    public static void main(String[] args) {
        List<C1> l = List.of(new C1(10, "t"), new C1(20, "k"), new C1(1, "o"));
        Comparator<C1> x = new Comparator<>() {
            @Override
            public int compare(C1 o1, C1 o2) {
                return o1.val - o2.val;
            }
        };

        List<C1> sl = l.stream().sorted(x).collect(Collectors.toUnmodifiableList());
        sl.stream().forEach(System.out::println);

        sl = l.stream().sorted((c1, c2) -> {return c2.val - c1.val;}).collect(Collectors.toList());
        sl.stream().forEach(System.out::println);

        BiFunction<C1, C1, Integer>biFunction = ((c1, c2) -> {return c2.val - c1.val;});
        //sl = l.stream().sorted(biFunction);
        sl.stream().forEach(System.out::println);
    }
}

