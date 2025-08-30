package com.student.management.services;

import com.student.management.models.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class to manage Student records
 */
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Remove student
    public boolean removeStudent(int rollNumber) {
        return students.removeIf(s -> s.getRollNumber() == rollNumber);
    }

    // Find by roll number
    public Optional<Student> findByRollNumber(int rollNumber) {
        return students.stream()
                .filter(s -> s.getRollNumber() == rollNumber)
                .findFirst();
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Sort by name
    public List<Student> sortByName() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    // Sort by average marks (descending)
    public List<Student> sortByAverageMarks() {
        return students.stream()
                .sorted(Comparator.comparingDouble((Student s) -> s.getResult().getAverageMarks()).reversed())
                .collect(Collectors.toList());
    }

    // Update student name
    public void updateStudentName(int rollNumber, String newName) {
        findByRollNumber(rollNumber).ifPresent(s -> {
            try {
                java.lang.reflect.Field field = s.getClass().getDeclaredField("name");
                field.setAccessible(true);
                field.set(s, newName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
