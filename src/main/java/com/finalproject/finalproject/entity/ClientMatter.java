package com.finalproject.finalproject.entity;

import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

public class ClientMatter {

    private Long id;
    private PracticeAreas practiceArea;
    private Date dateOpened;
    private Date dateClosed;
    private String matterStatus;
    private boolean isHourly;
    private Set<TimeEntry> TimeEntry;
    private Client client;
    private Lawyer lawyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PracticeAreas getPracticeArea() {
        return practiceArea;
    }

    public void setPracticeArea(PracticeAreas practiceArea) {
        this.practiceArea = practiceArea;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getMatterStatus() {
        return matterStatus;
    }

    public void setMatterStatus(String matterStatus) {
        this.matterStatus = matterStatus;
    }

    public boolean isHourly() {
        return isHourly;
    }

    public void setHourly(boolean hourly) {
        isHourly = hourly;
    }

    public Set<TimeEntry> getTimeEntry() {
        return TimeEntry;
    }

    public void setTimeEntry(Set<TimeEntry> timeEntry) {
        TimeEntry = timeEntry;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }
}
