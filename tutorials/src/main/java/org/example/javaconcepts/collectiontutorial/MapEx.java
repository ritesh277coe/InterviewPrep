package org.example.javaconcepts.collectiontutorial;

import java.util.*;

public class MapEx {
    public static void demo1() {
        Map<Test, String> map = new HashMap<>();TreeMap
        Test t1 = new Test(1, "one");
        Test t2 = new Test(2, "two");
        String old = map.put(t1, "ONE");
        System.out.println(old);
        old = map.put(t1, "ONE");
        System.out.println(old);
        old = map.put(t2, "TWO");

        System.out.println();
        Set<Test> keys = map.keySet();
        for (Test key: keys) {
            System.out.println(map.get(key));
        }

        Set<Map.Entry<Test, String>> set = map.entrySet();
        for (Map.Entry<Test, String> entry: set) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("Foreach demo");
        map.forEach((k, v)->{
            System.out.println(k+":"+v);
        });

        System.out.println();

        old = map.remove(t1);
        System.out.println("Removed " + old);
        System.out.println();

        map.clear();
        System.out.println("SIZE:" + map.size());
    }

    public static void demo2() {
        List<Test> list = new ArrayList<>();
        for (int i = 0; i< 100; i++) {
            int key = Rand.%
        }

    }
    public static void main(String[] args) {
        demo1();
        demo2();
    }
}
