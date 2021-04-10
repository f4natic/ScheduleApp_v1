package ru.f4n.app.models;

import java.util.Date;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private int purchasedClasses;
    private int conductedClasses;
    private int paid;
    private int residue;
    private Date nextLessonDate;
    private boolean isStudent;

    public User(long id, String firstName, String lastName,
                int purchasedClasses, int conductedClasses, int paid,
                int residue, Date nextLessonDate, boolean isStudent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.purchasedClasses = purchasedClasses;
        this.conductedClasses = conductedClasses;
        this.paid = paid;
        this.residue = residue;
        this.nextLessonDate = nextLessonDate;
        this.isStudent = isStudent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPurchasedClasses() {
        return purchasedClasses;
    }

    public void setPurchasedClasses(int purchasedClasses) {
        this.purchasedClasses = purchasedClasses;
    }

    public int getConductedClasses() {
        return conductedClasses;
    }

    public void setConductedClasses(int conductedClasses) {
        this.conductedClasses = conductedClasses;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getResidue() {
        return residue;
    }

    public void setResidue(int residue) {
        this.residue = residue;
    }

    public Date getNextLessonDate() {
        return nextLessonDate;
    }

    public void setNextLessonDate(Date nextLessonDate) {
        this.nextLessonDate = nextLessonDate;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }
}