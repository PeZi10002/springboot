package com.pezi.demo.service;

import java.util.List;

import com.pezi.demo.model.Abteilung;

public interface AbteilungsServiceInterface {

    // create
    public Abteilung createAbteilung(Abteilung abteilung);

    // read
    public Abteilung getAbteilungById(int id);

    public List<Abteilung> getAllAbteilung();

    // update
    public String updateAbteilung(Abteilung abteilung);

    // delete
    public String deleteAbteilungById(); // String Zurückgabe für Debugzwecke auf Postman-Seite

}
