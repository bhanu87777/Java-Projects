package com.student.management.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a Subject with its name and marks obtained.
 */
public class Subject implements Serializable {
    private String name;
    private double marks;

    public Subject(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
