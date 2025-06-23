package com.example.smartroomga.model;

public class Room {
    private String type;
    private boolean ac;

    public Room(String type, boolean ac) {
        this.type = type;
        this.ac = ac;
    }

    public String getType() { return type; }
    public boolean isAc() { return ac; }
}