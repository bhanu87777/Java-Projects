package com.student.management.utils;

import com.student.management.models.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class with common Stream operations.
 */
public class StreamUtils {

    // Convert List<Student> to just list of names
    public static List<String> extractStudentNames(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    // Extract list of roll numbers
    public static List<Integer> extractRollNumbers(List<Student> students) {
        return students.stream()
                .map(Student::getRollNumber)
                .collect(Collectors.toList());
    }

    // Filter students by grade
    public static List<Student> filterByGrade(List<Student> students, char grade) {
        return students.stream()
                .filter(s -> s.getResult().getGrade() == grade)
                .collect(Collectors.toList());
    }
}
