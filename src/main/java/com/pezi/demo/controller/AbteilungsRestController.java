package com.pezi.demo.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pezi.demo.model.Abteilung;
import com.pezi.demo.service.AbteilungsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("abteilung") // localhost:8080/abteilung genereller Pfad
public class AbteilungsRestController {
    @Autowired
    AbteilungsService service;

    /*
     * create Request (funktioniert) Getestet mit Json: { "abteilungsName" :
     * "Ldfagsffer" }
     */
    @PostMapping // localhost:8080/abteilung (Der Einfachheit halber)
    public ResponseEntity<Abteilung> createAbteilung(@RequestBody Abteilung abteilung) {
        this.service.createAbteilung(abteilung);
        // Hole diese gespeicherte Abteilung anhand der ID aus der Datenbank und returne
        // sie zu Debug-Zwecken
        return ResponseEntity.ok().body(service.getAbteilungById(abteilung.getAbteilungsId()));
    }

    // get all Abteilungen Request auf http://localhost:8080/abteilung
    // funktioniert
    @GetMapping
    public List<Abteilung> getAllAbteilungen() {
        return service.getAllAbteilungen();
    }

    // get Abteilung by ID - Request auf zB. http://localhost:8080/abteilung/1
    // funktioniert
    @GetMapping("/{id}") // localhost:8080/abteilung/[id]
    public Abteilung getAbteilungById(@PathVariable int id) {
        return service.getAbteilungById(id);
    }

    /*
     * Update PUT auf localhost:8080/abteilung/[id] inklusive Requestbody zB.:
     * {"abteilungsId": 1,"abteilungsName": "Updatetest"} funktioniert
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAbteilung(@PathVariable int id, @RequestBody Abteilung abteilung) {
        if (service.getAbteilungById(id).getAbteilungsId() == id) {
            service.updateAbteilung(abteilung);
            return ResponseEntity.ok().body(service.getAbteilungById(abteilung.getAbteilungsId()));
        } else
            return new ResponseEntity<String>("Konnte Abteilung nicht updaten. Eventuell nicht vorhanden.",
                    HttpStatus.NOT_FOUND);
    }

    // delete by id auf localhost:8080/abteilung/[id]
    @DeleteMapping("/{id}")
    @JsonIgnore
    public String deleteAbteilung(@PathVariable int id) {
        if (service.getAbteilungById(id).getAbteilungsId() == id) {
            service.deleteAbteilungById(id);
            return "Abteilung gelöscht.";
        } else
            return "Abteilung wohl nicht vorhanden, konnte nicht gelöscht werden.";
    }
}
