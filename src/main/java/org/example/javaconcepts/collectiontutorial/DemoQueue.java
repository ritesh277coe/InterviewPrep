package org.example.javaconcepts.collectiontutorial;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DemoQueue {

    public void demoQueue() {
        Queue<Test> queue = new PriorityQueue<Test>();
        List<Test> list = Arrays.asList(
                new Test(1, "one"),
                new Test(2, "Two")
        );
        queue.addAll(list);
        Test test = null;
        test = queue.peek();
        while ((test = queue.poll()) != null) {
            System.out.println(test.toString());
        }
        Set<Test> set = new HashSet<>();
        SortedSet<Test> s = new TreeSet<Test>((t1, t2)->{return (t1==t2)?0:(t1.a > t2.a)?1:-1;});

//        //Add Element
//        populateArrayListNormalWay(arrayList);
//        //Remove Element
//        removeElement(new Test(1, "One"), arrayList);
//        //Sort
//        arrayList.sort(getComparator());
//        //Iterator
//        iterateList(arrayList);
//        //Sort Using lambda
//        arrayList.sort((Test t1, Test t2) -> {return (t1.a > t2.a)?1:-1;});
//        //Iterator
//        iterateList(arrayList);
//        //ToArray
//        Test[] testArr = listToTestArray(arrayList);
//        for(Test t: testArr) {
//            System.out.println(t.a);
//        }
//
//        //Creating Arraylist from array
//        List<Test> newArrList = Arrays.asList(testArr);
//        //Iterator
//        iterateList(newArrList);

    }
}
