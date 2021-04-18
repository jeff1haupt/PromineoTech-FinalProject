package com.finalproject.finalproject.entity;

import javax.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finalproject.finalproject.entity.ClientMatter;

@Entity
public class PracticeAreas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String practiceAreas;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "lawyer", "clientMatter", "client"})
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "practiceArea")
    private ClientMatter clientMatter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPracticeAreas() {
        return practiceAreas;
    }

    public void setPracticeAreas(String practiceAreas) {
        this.practiceAreas = practiceAreas;
    }

    public ClientMatter getClientMatter() {
        return clientMatter;
    }

    public void setClientMatter(ClientMatter clientMatter) {
        this.clientMatter = clientMatter;
    }
}