package com.student.management.services;
import com.student.management.models.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class to analyze Student Results
 */
public class ResultService {

    // Get toppers
    public List<Student> getToppers(List<Student> students, int topN) {
        return students.stream()
                .sorted(Comparator.comparingDouble(
                        (Student s) -> s.getResult().getAverageMarks()   // force Student type
                ).reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }

    // Class average
    public double getClassAverage(List<Student> students) {
        return students.stream()
                .mapToDouble((Student s) -> s.getResult().getAverageMarks()) // explicit type
                .average()
                .orElse(0);
    }

    // Highest scorer
    public Optional<Student> getHighestScorer(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble((Student s) -> s.getResult().getTotalMarks()));
    }

    // Lowest scorer
    public Optional<Student> getLowestScorer(List<Student> students) {
        return students.stream()
                .min(Comparator.comparingDouble((Student s) -> s.getResult().getTotalMarks()));
    }

}
