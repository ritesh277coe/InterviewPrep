package org.example.javaconcepts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImmutableString {
    public static void areStringLiteralsCached() {
        String s1 = "Hello";
        String s2 = "Hello";

        System.out.println("Are reference of s1 and s2 string literal same " + (s1 == s2));

        String s3 = new String("Hello");
        System.out.println("Are reference of s1 and s3 string literal same " + (s1 == s3));
        System.out.println("Above s1 and s3 reference will not be same as s3 is created string object and is not using the cache");
        System.out.println("As you can see that above new String is grayed out and if you use the Intellij hint, then it will be replaced by \"Hello\" String, which internally will use the string pool");

        String s4 = new String("Hello").intern(); //either use "hello" or use .intern(). They both will force the use of stringpool
        System.out.println("Are reference of s1 and s4 string literal same " + (s1 == s4));
        System.out.println("Reference of s1 will be equal to s4 as we have forced the string to use the cache (string pool)");
    }

    public static void isStringImmutable() {
        String s1 = "Hello";
        s1.toUpperCase();   //Any modification on the original string will return a new modified string
        // and the original string will remain immutable
        System.out.println(s1); //Will print original string only

        String s2 = s1.toUpperCase();
        System.out.println(s2);

        System.out.println("Are reference of s1 and s2 string literal same " + (s1 == s2));
        System.out.println("False output means that s1 and s2 are different strings");

        System.out.println("Why String are immutable?");
        System.out.println("Since the string literal use the string pool cache, many instances of \"hello\" inside code will point to same memory location. If original string can be mutated, then all the instances of \"hello\" will be mutated and that will be catastrophic");
    }

    public static void stringRegex() {
        String s1 = "hello world";
        System.out.println(s1.matches("(.*) world"));

        String s2 = "helloworldhelloworldhelloworldhelloworld";
        Pattern pattern = Pattern.compile("hello");
        Matcher matcher = pattern.matcher(s2);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        System.out.println("Occurrences of hello in s2 string " + matches);
    }

    public static void stringBuilderExample() {
        //Bad practice:
        String s1 = "This " + "is " + "bad " + "practice";
        System.out.println(s1);
        System.out.println("The above style will create 5 strings in string pool, which were not needed");

        //Good practice when user wants to mutate string
        StringBuilder s2 = new StringBuilder("This ");
        s2.append("is ").append("good ").append("practice");
        System.out.println(s2);
    }


    public static void main(String[] args) {
        areStringLiteralsCached();
        isStringImmutable();
        stringRegex();
        //If user wants to mutate strings, then use stringBuffer(Threadsafe)/StringBuilder(Not threadsafe)
        //StringBuilder is commonly used
        stringBuilderExample();
    }
}

