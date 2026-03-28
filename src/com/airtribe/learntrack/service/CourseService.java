package com.airtribe.learntrack.service;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository = new CourseRepository();

    public void addCourse(String courseName, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course newCourse = new Course(id, courseName, description, durationInWeeks, true);
        courseRepository.addCourse(newCourse);
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public void updateCourse(int id, String courseName, String description, int durationInWeeks, boolean active) {
        Course course = courseRepository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }
        else {
            course.setCourseName(courseName);
            course.setDescription(description);
            course.setDurationInWeeks(durationInWeeks);
            course.setActive(active);
        }
    }

    public void deactivateCourse(int id) {
        Course course = courseRepository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }
        else {
            course.setActive(false);
        }
    }

    public void activateCourse(int id) {
        Course course = courseRepository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }
        else {
            course.setActive(true);
        }
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
