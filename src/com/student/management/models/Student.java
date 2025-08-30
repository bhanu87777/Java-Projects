package com.student.management.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Student with roll number, name, subjects, and result.
 */
public class Student implements Comparable<Student>, Serializable {
    private final int rollNumber;
    private final String name;
    private final List<Subject> subjects;
    private final Result result;

    public Student(int rollNumber, String name, List<Subject> subjects) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.subjects = subjects;
        this.result = new Result(this);
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNumber, other.rollNumber); // natural ordering by roll
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return rollNumber == student.rollNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", result=" + result +
                '}';
    }
}
