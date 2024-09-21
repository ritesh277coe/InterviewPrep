package org.example.javaconcepts.enums;

public enum JavaCoursesWithInfo {
    BEGINNER(1, "beginner"),
    INTERMEDIATE(2, "intermediate"),
    ADVANCED(3, "advanced"),
    SPECIALIZED_GENERICS(4, "specialized generics"),
    SPECIALIZED_COLLECTIONS(5, "specialized collections");

    public final int hardness;
    public final String description;

    JavaCoursesWithInfo(int hardness, String description) {
        this.hardness = hardness;
        this.description = description;
    }

}
