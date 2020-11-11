package com.pezi.demo.service;

import java.util.List;

import com.pezi.demo.model.Mitarbeiter;

public interface MitarbeiterServiceInterface {
    // create
    public Mitarbeiter createMitarbeiter(Mitarbeiter mitarbeiter);

    // read
    public Mitarbeiter getMitarbeiterById(int id);

    public List<Mitarbeiter> getAllMitarbeiter();

    // update
    public String updateMitarbeiter(Mitarbeiter mitarbeiter);

    // delete
    public String deleteMitarbeiterById(); // String Zurückgabe für Debugzwecke auf Postman-Seite

}
