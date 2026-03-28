package com.airtribe.learntrack.entity;

public class Student extends Person { //Inheritance; Student IS-A Person

    private String batch; //Encapsulation
    private boolean active;

    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email); // Calls the parent class constructor
        this.batch = batch;
        this.active = active;
    }

    public Student(int id, String firstName, String lastName, String batch, boolean active) {
        super(id, firstName, lastName, null); // Overloaded constructor without email
        this.batch = batch;
        this.active = active;
    }


    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
