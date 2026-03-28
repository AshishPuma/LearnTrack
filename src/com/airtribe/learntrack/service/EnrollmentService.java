package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();

    public void enrollStudent(int studentId, int courseId, String enrollmentDate, String status) {
        if (studentService.getStudentById(studentId) == null) { // Validate student exists
            System.out.println("Student not found!");
            return;
        }
        if (courseService.getCourseById(courseId) == null) { // Validate course exists
            System.out.println("Course not found!");
            return;
        }
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId, enrollmentDate, status);
        enrollmentRepository.addEnrollment(enrollment);
    }

    public Enrollment getEnrollmentById(int id) {
        return enrollmentRepository.findById(id);
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public void updateEnrollmentStatus(int id, String newStatus) {
        Enrollment enrollment = enrollmentRepository.findById(id);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found with ID: " + id);
        }
        else {
            enrollment.setStatus(newStatus);
        }
    }

    public void updateEnrollmentDate(int id, String newDate) {
        Enrollment enrollment = enrollmentRepository.findById(id);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found with ID: " + id);
        }
        else {
            enrollment.setEnrollmentDate(newDate);
        }
    }
}