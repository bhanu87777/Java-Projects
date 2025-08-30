package com.student.management.comparators;

import com.student.management.models.Student;
import java.util.Comparator;

/**
 * Comparator to sort Students by grade (A → F).
 */
public class StudentGradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Character.compare(s1.getResult().getGrade(), s2.getResult().getGrade());
    }
}
