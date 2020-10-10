package com.finalproject.finalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class AttorneyTimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double timeSpent;
    private Date dateEntry;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "lawyer", "client", "clientMatter"})
    @ManyToOne
    @JoinColumn(name = "clientMatterid")
    private ClientMatter clientMatter;

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

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }

    public ClientMatter getClientMatter() {
        return clientMatter;
    }

    public void setClientMatter(ClientMatter clientMatter) {
        this.clientMatter = clientMatter;
    }
}
