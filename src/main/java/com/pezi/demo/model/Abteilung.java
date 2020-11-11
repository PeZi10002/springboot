package com.pezi.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "abteilung")
public class Abteilung {

    @NotNull
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int abteilungsId;
    private String abteilungsName;
    // bidirektional??
    private Mitarbeiter mitarbeiter;

    // Konstruktoren
    public Abteilung(@NotNull int abteilungsId, String abteilungsName, Mitarbeiter mitarbeiter) {
        this.abteilungsId = abteilungsId;
        this.abteilungsName = abteilungsName;
        this.mitarbeiter = mitarbeiter;
    }

    // ohne Id - Autogenerierung
    public Abteilung(String abteilungsName, Mitarbeiter mitarbeiter) {
        this.abteilungsName = abteilungsName;
        this.mitarbeiter = mitarbeiter;
    }

    // ohne Mitarbeiter
    public Abteilung(String abteilungsName) {
        this.abteilungsName = abteilungsName;
    }

    // Getters & Setters

    public int getAbteilungsId() {
        return abteilungsId;
    }

    public void setAbteilungsId(int abteilungsId) {
        this.abteilungsId = abteilungsId;
    }

    public String getAbteilungsName() {
        return abteilungsName;
    }

    public void setAbteilungsName(String abteilungsName) {
        this.abteilungsName = abteilungsName;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

}
