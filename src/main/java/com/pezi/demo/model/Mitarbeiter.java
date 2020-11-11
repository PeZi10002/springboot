package com.pezi.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
    private int mId;

    @NotNull
    @Lob
    private String mVorname;

    @NotNull
    @Lob
    private String mNachname;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "abteilungsId" /* , nullable = false */)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Abteilung abteilung;

    // Getters and Setters

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmVorname() {
        return mVorname;
    }

    public void setmVorname(String mVorname) {
        this.mVorname = mVorname;
    }

    public String getmNachname() {
        return mNachname;
    }

    public void setmNachname(String mNachname) {
        this.mNachname = mNachname;
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }

}
