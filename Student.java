package com.example.smartroomga.model;

public class Student {
    private String preference;
    private int year;

    public Student(String preference, int year) {
        this.preference = preference;
        this.year = year;
    }

    public String getPreference() { return preference; }
    public int getYear() { return year; }
}