package com.finalproject.finalproject.entity;

import javax.persistence.*;
import java.util.Set;

import com.finalproject.finalproject.entity.ClientMatter;

@Entity
public class PracticeAreas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String practiceAreas;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "practiceArea")
    private Set<ClientMatter> clientMatters;

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

    public Set<ClientMatter> getMatters() {
        return clientMatters;
    }

    public void setMatters(Set<ClientMatter> clientMatters) {
        this.clientMatters = clientMatters;
    }
}