package com.ritesh.tutorial.basic.java.concepts.enums;

public class EnumTutorial {
    public static void main(String[] args) {
        JavaCourse javaCourse = JavaCourse.ADVANCED_JAVA_TUTORIAL;

        if (javaCourse == JavaCourse.ADVANCED_JAVA_TUTORIAL) {
            System.out.println("javacourse is " + javaCourse);
        }

        for (JavaCourse course: JavaCourse.values()) {
            System.out.println(course);
        }

        JavaCoursesWithInfo javaCoursesWithInfo =  JavaCoursesWithInfo.BEGINNER;
        System.out.println("Description " + javaCoursesWithInfo.BEGINNER.description + " Hardeness " + javaCoursesWithInfo.BEGINNER.hardness);
    }
}
