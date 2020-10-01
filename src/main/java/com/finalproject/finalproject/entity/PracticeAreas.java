package com.finalproject.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class PracticeAreas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String practiceAreas;

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
}