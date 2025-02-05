package org.example.javaconcepts;


import java.io.IOException;

public class ExceptionEx {
    private static class Test {
        public Test() {}
        public void testException() {
            throw new IllegalArgumentException("wow");
        }
    }

    public static void main(String[] args) {
        try {
            Test test = new Test();
            test.testException();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally{
            System.out.println("Finally");
        }

    }
}
