package org.example.design.pattern.structural;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class FacadeEx {
    public static void main(String[] args) {
        //MavenLifeCycle hide all the complexity of compiler tool chain gives easy interface to interact
        MavenLifeCycle mavenLifeCycle = new MavenLifeCycle();
        mavenLifeCycle.install();


        ConcurrentHashMap<Integer, Integer> bq = new ConcurrentHashMap<>(100);
        bq.put(10, 10);
        Iterator<Map.Entry<Integer, Integer>> it = bq.entrySet().iterator();
        while(it.hasNext()) {
            System.out.println(it.next().getKey());
            bq.put(100, 1000);
        }
    }
}
