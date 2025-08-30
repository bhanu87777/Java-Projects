package com.student.management.app;

import com.student.management.models.Student;
import com.student.management.models.Subject;
import com.student.management.services.StudentService;
import com.student.management.services.ResultService;
import com.student.management.services.FileStorageService;
import com.student.management.comparators.*;
import com.student.management.exceptions.StudentNotFoundException;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        ResultService resultService = new ResultService();
        FileStorageService fileService = new FileStorageService();

        // Create demo students
        Student s1 = new Student(1, "Alice", Arrays.asList(
                new Subject("Math", 95),
                new Subject("Science", 88),
                new Subject("English", 92)
        ));

        Student s2 = new Student(2, "Bob", Arrays.asList(
                new Subject("Math", 65),
                new Subject("Science", 70),
                new Subject("English", 60)
        ));

        Student s3 = new Student(3, "Charlie", Arrays.asList(
                new Subject("Math", 40),
                new Subject("Science", 45),
                new Subject("English", 38)
        ));

        studentService.addStudent(s1);
        studentService.addStudent(s2);
        studentService.addStudent(s3);

        System.out.println("=== All Students ===");
        studentService.getAllStudents().forEach(System.out::println);

        // Search student
        System.out.println("\n=== Search by Roll Number ===");
        int rollToSearch = 2;
        studentService.findByRollNumber(rollToSearch)
                .ifPresentOrElse(
                        System.out::println,
                        () -> { throw new StudentNotFoundException("Student with roll " + rollToSearch + " not found!"); }
                );

        // Sorting examples
        System.out.println("\n=== Sorted by Name ===");
        studentService.getAllStudents().stream()
                .sorted(new StudentNameComparator())
                .forEach(System.out::println);

        System.out.println("\n=== Sorted by Marks (High → Low) ===");
        studentService.getAllStudents().stream()
                .sorted(new StudentMarksComparator())
                .forEach(System.out::println);

        System.out.println("\n=== Sorted by Grade (A → F) ===");
        studentService.getAllStudents().stream()
                .sorted(new StudentGradeComparator())
                .forEach(System.out::println);

        // Result service usage
        System.out.println("\n=== Class Average ===");
        System.out.println(resultService.getClassAverage(studentService.getAllStudents()));

        System.out.println("\n=== Toppers (Top 2) ===");
        resultService.getToppers(studentService.getAllStudents(), 2).forEach(System.out::println);

        // Save to file
        try {
            fileService.save(studentService.getAllStudents());
            System.out.println("\nData saved to file successfully!");
        } catch (Exception e) {
            System.out.println("Error saving students: " + e.getMessage());
        }

        // Load from file
        try {
            List<Student> loaded = fileService.load();
            System.out.println("\n=== Loaded from File ===");
            loaded.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }
}
