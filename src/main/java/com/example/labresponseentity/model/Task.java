package com.example.labresponseentity.model;

public class Task {

    private int id;
    private String title;
    private int assignedTo;

    public Task() {
    }

    public Task(int id, String title, int assignedTo) {
        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }
}