package com.finalproject.finalproject.entity;

import java.util.Date;
import java.util.Set;

public class ClientMatter {

    private Long id;
    private Set<PracticeAreas> PracticeAreas;
    private Date dateOpened;
    private Date dateClosed;
    private String matterStatus;
    private boolean isHourly;
    private Set<TimeEntry> TimeEntry;
    private Set<Client> Client;
    private Set<Lawyer> Lawyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<com.finalproject.finalproject.entity.PracticeAreas> getPracticeAreas() {
        return PracticeAreas;
    }

    public void setPracticeAreas(Set<com.finalproject.finalproject.entity.PracticeAreas> practiceAreas) {
        PracticeAreas = practiceAreas;
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

    public Set<com.finalproject.finalproject.entity.TimeEntry> getTimeEntry() {
        return TimeEntry;
    }

    public void setTimeEntry(Set<com.finalproject.finalproject.entity.TimeEntry> timeEntry) {
        TimeEntry = timeEntry;
    }

    public Set<com.finalproject.finalproject.entity.Client> getClient() {
        return Client;
    }

    public void setClient(Set<com.finalproject.finalproject.entity.Client> client) {
        Client = client;
    }

    public Set<com.finalproject.finalproject.entity.Lawyer> getLawyer() {
        return Lawyer;
    }

    public void setLawyer(Set<com.finalproject.finalproject.entity.Lawyer> lawyer) {
        Lawyer = lawyer;
    }
}
