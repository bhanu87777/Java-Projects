package com.student.management.exceptions;

/**
 * Custom exception thrown when a Student is not found in the system.
 */
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
