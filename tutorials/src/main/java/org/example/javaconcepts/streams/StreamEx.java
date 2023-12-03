package org.example.javaconcepts.streams;

import org.example.helpercode.LoadJsonFile;
import org.example.helpercode.Person;
import org.example.helpercode.PersonDto;
import java.io.IOException;
import java.util.List;

//Good Resource:
//https://github.com/amigoscode/java-streams/
public class StreamEx {
    public static void main(String[] args) throws IOException {
        List<Person> personList = LoadJsonFile.getPeople();

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
                .forEach(System.out::println);

//        personList.stream()
//                .forEach(p -> {System.out.println(p);});// foreach take consumer that take arg but return nothing

    }

    public static boolean ageFilter(Person p) {
        if(p.getAge() < 5)
            return true;
        else
            return false;
    }

}
