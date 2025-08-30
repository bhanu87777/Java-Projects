package com.student.management.comparators;

import com.student.management.models.Student;
import java.util.Comparator;

/**
 * Comparator to sort Students by their average marks (High → Low).
 */
public class StudentMarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getResult().getAverageMarks(), s1.getResult().getAverageMarks());
    }
}
