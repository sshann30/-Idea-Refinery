package com.example.demo;

//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;

public class Task {
    private String title;
    private String description;
    private boolean completed;
    private Date createDate;
    private Date completedDate;


    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createDate = new Date();
        this.completedDate = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
        if (completed) {
            this.completedDate = new Date();
        } else {
            this.completedDate = null;
        }
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }
}