package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class C2 {
//    public void f1() {
//        System.out.println("In f2");
//    }
//    private void p1() {
//        System.out.println("In C2:p1");
//        LocalDate lc;
//    }
    int a;
    int b;
    String s;

    public C2(int a, int b, String s) {
        this.a = a;
        this.b = b;
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof C2) {
            C2 o = (C2)obj;
            return this.a == o.a && this.b == o.b && this.s.equals(o.s);
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "test";
        System.out.println(s1==s2);

        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf(11);
        System.out.println(i1 == i2);

        C2 o1 = new C2(10, 20, "cool");
        C2 o2 = new C2(10, 20, "cool");
        System.out.println(o1 == o2);
        System.out.println(o1.equals(o2));
    }
}


class Singleton {
    private static Singleton obj = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (obj == null) {
            obj = new Singleton();
        }
        return obj;
    }

    public int test() {
        Comparator<C2> c = new Comparator<>() {
            @Override
            public int compare(C2 o1, C2 o2) {
                return o1.a - o2.a;
            }
        };
        C2 arr[] = {};
        Arrays.sort(arr, c);
        Arrays.sort(arr, (a, b) -> {return a.a-b.a;});
        return 0;
    }
}
