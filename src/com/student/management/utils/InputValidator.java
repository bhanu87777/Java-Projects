package com.student.management.utils;

/**
 * Utility class for validating inputs like roll number, name, and marks.
 */
public class InputValidator {

    public static boolean isValidRollNumber(int rollNumber) {
        return rollNumber > 0;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("^[A-Za-z ]+$");
    }

    public static boolean isValidMarks(double marks) {
        return marks >= 0 && marks <= 100;
    }
}
