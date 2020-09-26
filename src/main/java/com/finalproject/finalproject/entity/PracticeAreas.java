package com.finalproject.finalproject.entity;

import java.util.Set;

public class PracticeAreas {

    private Long id;
    private Set<String> practiceAreas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<String> getPracticeAreas() {
        return practiceAreas;
    }

    public void setPracticeAreas(Set<String> practiceAreas) {
        this.practiceAreas = practiceAreas;
    }
}