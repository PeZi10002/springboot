package com.pezi.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "abteilung")
public class Abteilung {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int abteilungsId;
    private String abteilungsName;

    // Konstruktoren

    public Abteilung(@NotNull int abteilungsId, String abteilungsName) {
        this.abteilungsId = abteilungsId;
        this.abteilungsName = abteilungsName;
    }

    // ohne Id - Autogenerierung
    public Abteilung(String abteilungsName) {
        this.abteilungsName = abteilungsName;
    }

    public Abteilung() {
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

}
