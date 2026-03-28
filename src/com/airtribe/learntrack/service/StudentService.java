package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

    public void addStudent(String firstName, String lastName, String email, String batch) {
        int newId = IdGenerator.getNextStudentId(); // Simple ID generation
        Student newStudent = new Student(newId, firstName, lastName, email, batch, true);
        studentRepository.addStudent(newStudent);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(int id, String firstName, String lastName, String email, String batch, boolean active) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }
        else {
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setEmail(email);
            student.setBatch(batch);
            student.setActive(active);
        }
    }

    public void deactivateStudent(int id){
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }
        else {
            student.setActive(false);
        }
    }

    public void activateStudent(int id){
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }
        else {
            student.setActive(true);
        }
    }
}
