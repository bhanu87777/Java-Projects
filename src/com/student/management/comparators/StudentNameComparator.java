package com.student.management.comparators;

import com.student.management.models.Student;
import java.util.Comparator;

/**
 * Comparator to sort Students by their name (A-Z).
 */
public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}
