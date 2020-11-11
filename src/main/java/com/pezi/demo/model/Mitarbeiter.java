package com.pezi.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Mitarbeiter")
public class Mitarbeiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int mitarbeiterId;

    @NotNull
    @Lob
    private String mitarbeiterVorname;

    @NotNull
    @Lob
    private String mitarbeiterNachname;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "abteilungsId" /* , nullable = false */)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Abteilung abteilung;

    public Mitarbeiter(int mitarbeiterId, @NotNull String mitarbeiterVorname, @NotNull String mitarbeiterNachname,
            Abteilung abteilung) {
        this.mitarbeiterId = mitarbeiterId;
        this.mitarbeiterVorname = mitarbeiterVorname;
        this.mitarbeiterNachname = mitarbeiterNachname;
        this.abteilung = abteilung;
    }

    public Mitarbeiter(@NotNull String mitarbeiterVorname, @NotNull String mitarbeiterNachname, Abteilung abteilung) {

        this.mitarbeiterVorname = mitarbeiterVorname;
        this.mitarbeiterNachname = mitarbeiterNachname;
        this.abteilung = abteilung;
    }

    public Mitarbeiter() {
    }

    // Getters and Setters

    public int getMitarbeiterId() {
        return mitarbeiterId;
    }

    public void setMitarbeiterId(int mitarbeiterId) {
        this.mitarbeiterId = mitarbeiterId;
    }

    public String getMitarbeiterVorname() {
        return mitarbeiterVorname;
    }

    public void setMitarbeiterVorname(String mitarbeiterVorname) {
        this.mitarbeiterVorname = mitarbeiterVorname;
    }

    public String getMitarbeiterNachname() {
        return mitarbeiterNachname;
    }

    public void setMitarbeiterNachname(String mitarbeiterNachname) {
        this.mitarbeiterNachname = mitarbeiterNachname;
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }

}
