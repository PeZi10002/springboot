package com.pezi.demo.controller;

import java.util.List;

import com.pezi.demo.model.Abteilung;
import com.pezi.demo.service.AbteilungsService;

import org.springframework.beans.factory.annotation.Autowired;
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

    // create Request
    @PostMapping /* ("createAbteilung") */
    // localhost:8080/abteilung/createAbteilung
    // DER EINFACHHEIT HALBER ALLE REQUESTS AN /abteilung geleitet, damit Sie nicht
    // verschiedene URI`s eingeben müssen
    public ResponseEntity<Abteilung> createAbteilung(@RequestBody Abteilung abteilung) {
        this.service.createAbteilung(abteilung);
        // Hole diese gespeicherte Abteilung anhand der ID aus der Datenbank und returne
        // sie zu Debug-Zwecken
        return ResponseEntity.ok().body(service.getAbteilungById(abteilung.getAbteilungsId()));
    }

    // get all Abteilungen Request
    @GetMapping
    public List<Abteilung> getAllAbteilungen() {
        return service.getAllAbteilungen();
    }

    // get Abteilung by ID - Request
    @GetMapping("/{id}") // localhost:8080/abteilung/[id]
    public Abteilung getAbteilungById(@PathVariable int id) {
        return service.getAbteilungById(id);
    }

    // Update (Requestbody mit ganzen Abteilungsobjekt inkl. id übergeben)
    @PutMapping("/{id}") // localhost:8080/abteilung/[id]
    public ResponseEntity<Abteilung> updateAbteilung(@PathVariable int id, @RequestBody Abteilung abteilung) {
        service.updateAbteilung(abteilung);

        return ResponseEntity.ok().body(service.getAbteilungById(abteilung.getAbteilungsId()));
    }

    // delete by id
    @DeleteMapping("/{id") // localhost:8080/abteilung/[id]
    public String deleteAbteilung(@PathVariable int id) {
        service.deleteAbteilungById(id);
        return "Abteilung gelöscht.";
    }

}
