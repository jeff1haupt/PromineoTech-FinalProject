package com.finalproject.finalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class ClientMatter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOpened;
    private Date dateClosed;
    private String matterStatus;
    private boolean isHourly;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientMatterid")
    private PracticeAreas practiceArea;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "clientMatter", "lawyers"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientid")
    private Client client;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "client", "clientMatter"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "lawyer_cases",
            joinColumns = @JoinColumn(name = "clientMatterid"),
            inverseJoinColumns = @JoinColumn(name = "lawyerid")
    )
    private Set<Lawyer> lawyer;

    @OneToMany
    @JoinColumn(name = "clientMatterid")
    private Set<AttorneyTimeEntry> entry;

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

    public Set<AttorneyTimeEntry> getEntry() {
        return entry;
    }

    public void setEntry(Set<AttorneyTimeEntry> entry) {
        this.entry = entry;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Lawyer> getLawyer() {
        return lawyer;
    }

    public void setLawyer(Set<Lawyer> lawyer) {
        this.lawyer = lawyer;
    }
}
