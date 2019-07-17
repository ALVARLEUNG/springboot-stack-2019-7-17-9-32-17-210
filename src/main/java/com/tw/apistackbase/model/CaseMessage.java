package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
public class CaseMessage {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String mainDescription;

    @Column(nullable = false)
    private String minorDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "case_id", referencedColumnName = "id")
    CriminalCase criminalCase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getMinorDescription() {
        return minorDescription;
    }

    public void setMinorDescription(String minorDescription) {
        this.minorDescription = minorDescription;
    }

    public CriminalCase getCriminalCase() {
        return criminalCase;
    }

    public void setCriminalCase(CriminalCase criminalCase) {
        this.criminalCase = criminalCase;
    }
}
