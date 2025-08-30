package com.student.management.models;

import java.io.Serializable;
import java.util.List;

/**
 * Represents the result of a student including total, average, and grade.
 */
public class Result implements Serializable {
    private double totalMarks;
    private double averageMarks;
    private char grade;
    private boolean passed;

    public Result(Student student) {
        calculateResult(student.getSubjects());
    }

    private void calculateResult(List<Subject> subjects) {
        this.totalMarks = subjects.stream().mapToDouble(Subject::getMarks).sum();
        this.averageMarks = subjects.stream().mapToDouble(Subject::getMarks).average().orElse(0);

        if (averageMarks >= 90) grade = 'A';
        else if (averageMarks >= 75) grade = 'B';
        else if (averageMarks >= 50) grade = 'C';
        else grade = 'F';

        this.passed = grade != 'F';
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    public char getGrade() {
        return grade;
    }

    public boolean isPassed() {
        return passed;
    }

    @Override
    public String toString() {
        return "Result{" +
                "totalMarks=" + totalMarks +
                ", averageMarks=" + averageMarks +
                ", grade=" + grade +
                ", passed=" + passed +
                '}';
    }
}
