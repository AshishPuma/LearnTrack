package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    // Find student by ID
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Not found
    }

    // Get all students
    public List<Student> findAll() {
        return new ArrayList<>(students); // Return a copy to prevent external modification
    }
}