package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        if (course != null) {
            courses.add(course);
        }
    }

    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null; // Not found
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses); // Return a copy to prevent external modification
    }

}
