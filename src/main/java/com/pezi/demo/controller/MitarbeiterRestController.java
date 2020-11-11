package com.pezi.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.pezi.demo.model.Mitarbeiter;
import com.pezi.demo.service.MitarbeiterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mitarbeiter") // Genereller Pfad: localhost:8080/mitarbeiter
public class MitarbeiterRestController {
    @Autowired
    private MitarbeiterService service;

    // Create new Mitarbeiter
    @PostMapping
    public ResponseEntity<Mitarbeiter> createMitarbeiterRequestMethode(@Valid @RequestBody Mitarbeiter mitarbeiter) {
        try {
            service.createMitarbeiter(mitarbeiter);
            return ResponseEntity.ok().body(service.getMitarbeiterById(mitarbeiter.getMitarbeiterId()));
        } catch (Exception e) {

            System.out.println("Mitarbeiter konnte bei Postrequest nicht angelegt werden.");
            return null;
        }
    }

    // Get All Mitarbeiter - Request. Pfad /mitarbeiter
    public ResponseEntity<List<Mitarbeiter>> getAllMitarbeiterRequestMethode() {
        return ResponseEntity.ok().body(service.getAllMitarbeiter());
    }

    // Get Mitarbeiter by Mitarbeiter-ID Request
    @GetMapping("/{id}") // localhost:8080/mitarbeiter/[id]
    public ResponseEntity<Mitarbeiter> getMitarbeiterByIdRequestMethode(@PathVariable int id) {
        return ResponseEntity.ok().body(service.getMitarbeiterById(id));
    }

    // Update Mitarbeiter
    @PutMapping("{id}")
    public ResponseEntity<?> updateMitarbeiterRequestMethode(@PathVariable int id,
            @RequestBody Mitarbeiter mitarbeiter) {
        if (service.getMitarbeiterById(id).getMitarbeiterId() == mitarbeiter.getMitarbeiterId()) {
            service.updateMitarbeiter(mitarbeiter);
            return ResponseEntity.ok().body(service.getMitarbeiterById(mitarbeiter.getMitarbeiterId()));
        } else
            return new ResponseEntity<String>("Konnte Abteilung nicht updaten!", HttpStatus.NOT_FOUND);
    }

}
