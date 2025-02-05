package org.example.javaconcepts.streams;

import org.example.helpercode.LoadJsonFile;
import org.example.helpercode.Person;
import org.example.helpercode.PersonDto;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Good Resource:
//https://github.com/amigoscode/java-streams/

public class StreamEx {

    static List<Persons> getListOfPerson() {
        List<Persons> persons = List.of(
                new Persons(1, "Alex", 100d, new Department(1, "HR")),
                new Persons(2, "Brian", 200d, new Department(1, "HR")),
                new Persons(3, "Charles", 900d, new Department(2, "Finance")),
                new Persons(4, "David", 200d, new Department(2, "Finance")),
                new Persons(5, "Edward", 200d, new Department(2, "Finance")),
                new Persons(6, "Frank", 800d, new Department(3, "ADMIN")),
                new Persons(7, "George", 900d, new Department(3, "ADMIN")));
        return persons;
    }

    static void sum() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Optional<Integer> x = list.stream().min((a, b) -> a.compareTo(b));

        //Sum using reduce
        int s = list.stream().reduce(0, (sum, i) -> {return sum+i;});
        System.out.println(s);

        s = list.stream().mapToInt(e->e).sum();
        System.out.println(s);

        //Find min using reduce
        int minV = list.stream()
                .reduce(Integer.MAX_VALUE,
                        (sum, i) -> {if (i < sum)sum = i;  return sum;});
        System.out.println(minV);

    }
    static void reverseString() {
        String str = "string";

        String reverse = Stream.of(str.split(""))
                .reduce("", (sum, s) -> {return s+sum;} );

        System.out.println(reverse);
    }

    static void Reduce() {
        List<Integer> list = List.of(1,2,3,4,2,3, 3, 4, 4, 4, 4);
        int sum = list.stream()
                .reduce(0, (accumulate, value)-> {return accumulate+value;} );

        List<Persons> persons = getListOfPerson();

        Double totalSalary = persons.stream()
                .map(p -> p.salary)//Note that salSum and salary are of same type. Thats why map was needed
                .reduce(0.0, (salSum, salary) -> {return salSum += salary;});

        System.out.println(totalSalary);
    }

    static void AverageSalaryOfDeptUsingGroupBy() {
        List<Persons> persons = getListOfPerson();

        var l = persons.stream()
                .collect(Collectors.groupingBy(p -> p.department.id))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> {
                    return (e.getValue().stream().mapToDouble(p -> p.salary).sum())/e.getValue().size(); }));

        var l1 = persons.stream()
                .collect(Collectors.groupingBy(p -> p.department.id, Collectors.averagingDouble(p -> p.salary)));

        System.out.println();
    }

    static void groupByExample() {
        List<Persons> persons = getListOfPerson();

        Map<Integer, List<Persons>> lp = persons.stream()
                .collect(Collectors.groupingBy(p -> p.department.id));

        persons.stream()
                .collect(Collectors.groupingBy(p -> p.department.id))
                .entrySet()
                .stream()
                .forEach((m)-> {
                    System.out.println(m.getKey());
                    m.getValue().stream().forEach(x -> System.out.println(x.name)
                    );
                });

        var l = persons.stream()
                .collect(Collectors.groupingBy(p -> p.department.id))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().size()));



        System.out.println("");
    }

    static void hasDuplicatesByGroupBy() {
        List<Integer> list = List.of(1,2,3,4,2,3, 3, 4, 4, 4, 4);
        list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    static void findDuplicateAndItsCountByGroupBy() {
        List<Integer> list = List.of(1,2,3,4,2,3, 3, 4, 4, 4, 4);

        list.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()))
                        .entrySet().stream().filter(e -> {return  e.getValue() > 1;})
                        .map(e -> e.getKey())
                        .collect(Collectors.toList())
                        .forEach(System.out::println);

        //Map<Integer, Integer> map =
        list.stream().collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .filter(a -> {return a.getValue().size() > 1;})
                .collect(Collectors.toMap((a) -> {return a.getKey();},
                        (a) -> {return a.getValue().size();}))
                .entrySet()
                .stream()
                .forEach(a -> {
                    System.out.println(a.getKey() + " " + a.getValue());
                });

        System.out.println("\n");
    }

    public static boolean ageFilter(Person p) {
        if(p.getAge() < 5)
            return true;
        else
            return false;
    }

    public static void wordCount() {
        String sentence = "The cat has black fur and black eyes";
        String[] bites = sentence.trim().split("\\s+");

        Arrays.stream(bites)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + "::" + entry.getValue()));
    }
    public static int findFirstDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        AtomicBoolean duplicate = new AtomicBoolean(false);
        AtomicInteger num = new AtomicInteger();
        try {
            Arrays.stream(arr)
                    .forEach(a -> {
                        if (!set.add(a)) {
                            num.set(a);

                        }
                    });

        } catch (Exception ex) {
            System.out.println(num.get());
        }
        System.out.println(num.get());
        return num.get();
    }

    public static void main(String[] args) throws IOException {
        sum();
        reverseString();

        AverageSalaryOfDeptUsingGroupBy();
        groupByExample();
        findDuplicateAndItsCountByGroupBy();

        class City {
            String name;
            Integer temp;

            public City(String s, Integer temp) {
                name = s;
                this.temp = temp;
            }
        };

        String s = "1234";
        String x = "1234";
        String s1 = new String(x);
        List<Person> personList = LoadJsonFile.getPeople();

        List<City> l = List.of(new City("delhi", 11),
                new City("delhi", 12) );

        Map<String, List<City>> m = l.stream().filter(c -> c.temp > 10)
                        .collect(Collectors.groupingBy(c -> c.name));
        Set<Map.Entry<String, List<City>>> e = m.entrySet();
        for (Map.Entry<String, List<City>> entry: e) {
            System.out.println(entry.getKey());
            entry.getValue().stream().forEach(v -> System.out.println(v.temp));
        }




        System.out.println(personList.stream().
                filter(p -> {
                    if(p.getAge() > 18)
                        return true;
                    else
                        return false;}).
                findFirst().toString()
        );

//        personList.stream().
//                filter(p -> {
//                    }).
//                collect(Collectors.toList())
//                .forEach(System.out::println);

        //Important to change return type using map
        personList.stream()
                .filter(StreamEx::ageFilter)
                .map(person -> PersonDto.getDtoFromPerson(person))
                .distinct()
                .forEach(System.out::println);

//        personList.stream()
//                .forEach(p -> {System.out.println(p);});// foreach take consumer that take arg but return nothing

        int[] arr = {1, 2, 3,  1, 3};
        findFirstDuplicate(arr);

        String[] arr1 = {"Ritesh", "Singh", "Ritesh", "Pooja", "Singh"};
        {
            Map<String, Integer> map = new HashMap<>();
            Arrays.stream(arr1)
                    .forEach((k) ->{
                        Integer v = map.get(k);
                        if (v == null) v=1;
                        else v= v+1;
                        map.put(k, v);
                    });
            map.forEach((k, v) -> System.out.println(k+"::"+ v));
        }

        //THE ONLY WAY TO REMOVE ELEMENT IS ITERATOR
        {
            List<Integer> al = new ArrayList<>();

            // Adding elements to our ArrayList
            // using add() method
            al.add(10);
            al.add(20);
            al.add(30);
            al.add(1);
            al.add(2);

            Iterator<Integer> it = al.iterator();
            while (it.hasNext()) {
                if (it.next() == 30)
                    it.remove();
            }
        }
        {
            // Creating an object of List interface with
            // reference to ArrayList class
            List<Integer> al = new ArrayList<>();

            // Adding elements to our ArrayList
            // using add() method
            al.add(10);
            al.add(20);
            al.add(30);
            al.add(1);
            al.add(2);

            // Printing the current ArrayList
            System.out.println(al);

            // This makes a call to remove(int) and
            // removes element 20
            al.remove(1);

            // Now element 30 is moved one position back
            // So element 30 is removed this time
            //Cant remove element in for loop
            int x1 = 0;
            for (Integer i: al) {
                if (i == 30) {
                    al.remove(x1);
                    continue;
                }
                System.out.println(i);
                x1++;
            }
            al.remove(1);

            // Printing the updated ArrayList
            System.out.println(al);
        }

        {
            Arrays.asList(arr1).forEach(a -> {a= a+"singh";});
            Arrays.asList(arr1).forEach(System.out::println);

            List<String> list= Arrays.asList(arr1);
//            list = List.of(
//                    "Ritesh", "Singh", "Ritesh", "Pooja", "Singh"
//            );

            // Any list created from arrays can not be deleted using remove(i)
            int remove=0;
            list.remove(3); //remove is unsupported
        }
    }
}
