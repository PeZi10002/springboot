package com.pezi.demo.service;

import java.util.List;
import java.util.Optional;

import com.pezi.demo.model.Mitarbeiter;
import com.pezi.demo.repository.MitarbeiterRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class MitarbeiterService implements MitarbeiterServiceInterface {
    @Autowired
    private MitarbeiterRepository repo;

    @Override
    public Mitarbeiter createMitarbeiter(Mitarbeiter mitarbeiter) {
        return repo.save(mitarbeiter);
    }

    @Override
    public String deleteMitarbeiterById(int id) {
        repo.deleteById(id);
        return "Mitarbeiter gelöscht...";
    }

    @Override
    public List<Mitarbeiter> getAllMitarbeiter() {
        return repo.findAll();
    }

    @Override
    public Mitarbeiter getMitarbeiterById(int id) {
        return repo.findById(id).get(); // findById returnt Optional, deshalb .get
    }

    @Override
    public String updateMitarbeiter(Mitarbeiter mitarbeiter) {
        Optional<Mitarbeiter> mitarbeiterDb = repo.findById(mitarbeiter.getMitarbeiterId());
        // get unten nicht vergessen, optional!

        if (mitarbeiterDb.isPresent()) {
            Mitarbeiter m = mitarbeiterDb.get();
            m.setMitarbeiterId(mitarbeiter.getMitarbeiterId());
            m.setMitarbeiterNachname(mitarbeiter.getMitarbeiterNachname());
            m.setMitarbeiterVorname(mitarbeiter.getMitarbeiterVorname());

            repo.save(m);
            // return repo.findById(m.getMitarbeiterId()).get());
            return "Mitarbeiter Update erfolgt.";
        } else
            return "Keine Mitarbeiter zum Updaten existent.";

    }

}
