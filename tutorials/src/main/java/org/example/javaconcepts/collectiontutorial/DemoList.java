package org.example.javaconcepts.collectiontutorial;

import org.example.helpercode.Person;

import java.util.*;

public class DemoList {
    public DemoList() {
    }
    
    public void populateArrayListNormalWay(List<Test> list) {
        System.out.println("Add Element in list");
        list.add(new Test(1, "One"));
        list.add(new Test(2, "Two"));
        list.add(new Test(3, "Three"));
        iterateList(list);
    }

    public void removeElement(Test t, List<Test> list) {
        System.out.println("removeElement");
        list.remove(t);
        iterateList(list);
    }

    public  void iterateList(List<Test> list) {
        System.out.println("IterateList");
        for (Test t: list) {
            System.out.println(t.a + " " + t.name) ;
        }
    }

    public Object[] listToObjectArray(List<Test> list) {
        System.out.println("ToArray");
        return list.toArray();
    }

    public Test[] listToTestArray(List<Test> list) {
        System.out.println("ToArray");
        return list.toArray(new Test[1]);
    }

    public Comparator<Test> getComparator() {
        Comparator<Test> testComparator = new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return o1.a < o2.a?1:-1;
            }
        };

        return testComparator;
    }

    /**
     * Show usage of::
     * add,
     * remove,
     * sort(comparator), sort(lambda)
     * iterate,
     * toArray
     * Other apis to remember are addAll(collection), removerAll(collection), replaceAll, size(), isEmpty(), contains()
     */
    public void demoList() {
        {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add( new Person(1, "a", "b", "a@b", "m", 2));
            persons.add(new Person(2, "a", "b", "a@b", "m", 2));

            Person[] arr = persons.toArray(new Person[0]);
            ArrayList<Person> clonePersons = (ArrayList<Person>)persons.clone();
        }
        List<Test> arrayList = new ArrayList<Test>();
        //LinkedList, PriorityQueue, Arrays, Set, Collection, List, SortedSet, HashSet, TreeSet, Collections.singleton(Object), Collections.EMPTY_SET, Map. HashMap, TreeMap

        //Add Element
        populateArrayListNormalWay(arrayList);
        //Remove Element
        removeElement(new Test(1, "One"), arrayList);
        //Sort
        arrayList.sort(getComparator());
        //Iterator
        iterateList(arrayList);
        //Sort Using lambda
        arrayList.sort((Test t1, Test t2) -> {return (t1.a > t2.a)?1:-1;});
        //Iterator
        iterateList(arrayList);
        //ToArray
        Test[] testArr = listToTestArray(arrayList);
        for(Test t: testArr) {
            System.out.println(t.a);
        }

        //Creating Arraylist from array
        List<Test> newArrList = Arrays.asList(testArr);
        //Iterator
        iterateList(newArrList);

    }

    public static void main(String[] args) {
        DemoList demoList = new DemoList();
        demoList.demoList();
    }
}
