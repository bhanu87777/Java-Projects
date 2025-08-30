package com.student.management.services;

import com.student.management.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * File-based storage for Student Records
 */
public class FileStorageService {
    private static final String FILE_NAME = "students.ser";

    // Save to file
    public void save(List<Student> students) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        }
    }

    // Load from file
    @SuppressWarnings("unchecked")
    public List<Student> load() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Student>) ois.readObject();
        }
    }
}
