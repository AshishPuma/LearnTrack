package com.airtribe.learntrack.entity;

public class Trainer extends Person {

    private String expertise;
    private int experience;

    public Trainer(int id, String firstName, String lastName, String email, String expertise, int experience) {
        super(id, firstName, lastName, email);
        this.expertise = expertise;
        this.experience = experience;
    }

    public String getExpertise() {
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
