package com.airtribe.learntrack.entity;

public class Trainer extends Person {////Inheritance; Trainer IS-A Person

    private String expertise; //Encapsulation
    private int experience;

    public Trainer(int id, String firstName, String lastName, String email, String expertise, int experience) {
        super(id, firstName, lastName, email); //Calls the parent class constructor
        this.expertise = expertise;
        this.experience = experience;
    }

    public String getExpertise() { //Controlled access
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
