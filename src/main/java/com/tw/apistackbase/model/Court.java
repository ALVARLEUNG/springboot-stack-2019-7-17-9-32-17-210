package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Court {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "examinant_id", referencedColumnName = "id")
    private List<Examinant> examinants;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Examinant> getExaminants() {
        return examinants;
    }

    public void setExaminants(List<Examinant> examinants) {
        this.examinants = examinants;
    }
}
