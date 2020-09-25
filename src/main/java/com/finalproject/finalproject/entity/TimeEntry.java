package com.finalproject.finalproject.entity;

import java.util.Date;

public class TimeEntry {

    private Long id;
    private String description;
    private double timeEntry;
    private Date dateEntry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTimeEntry() {
        return timeEntry;
    }

    public void setTimeEntry(double timeEntry) {
        this.timeEntry = timeEntry;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }
}
