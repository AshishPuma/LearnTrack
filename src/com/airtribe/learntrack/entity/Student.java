package com.airtribe.learntrack.entity;

public class Student extends Person {

    private String course;
    private int year;

    public Student(int id, String firstName, String lastName, String email, String course, int year) {
        super(id, firstName, lastName, email);
        this.course = course;
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
