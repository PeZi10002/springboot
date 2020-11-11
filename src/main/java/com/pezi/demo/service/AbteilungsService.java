package com.pezi.demo.service;

import java.util.List;
import java.util.Optional;

import com.pezi.demo.model.Abteilung;
import com.pezi.demo.repository.AbteilungsRepository;

import org.springframework.stereotype.Service;

@Service
public class AbteilungsService implements AbteilungsServiceInterface {
    private AbteilungsRepository repo.

    @Override
    public Abteilung createAbteilung(Abteilung abteilung) {
        repo.save(abteilung);
    }

    @Override
    public String deleteAbteilungById(int id) {
        repo.deleteById(id);
        return "Abteilung wurde gelöscht";
    }

    @Override
    public Abteilung getAbteilungById(int id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Abteilung> getAllAbteilung() {
        return repo.findAll();
    }

    @Override
    public String updateAbteilung(Abteilung abteilung) {
        Optional<Abteilung> abteilungDb = repo.findById(abteilung.getAbteilungsId());
        // get unten nicht vergessen, optional!

        if (abteilungDb.isPresent()) {
            Abteilung a = abteilungDb.get();
            a.setAbteilungsId(abteilung.getAbteilungsId());
            a.setAbteilungsName(abteilung.getAbteilungsName());

            repo.save(a);
            // return repo.findById(m.getAbteilungId()).get());
            return "Abteilung Update ist erfolgt.";
        } else
            return "Keine Abteilung zum Updaten existent.";
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
