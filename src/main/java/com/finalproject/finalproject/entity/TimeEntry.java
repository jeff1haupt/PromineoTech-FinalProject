package com.finalproject.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TimeEntry {

    private Long id;
    private String description;
    private double timeEntry;
    private Date dateEntry;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
