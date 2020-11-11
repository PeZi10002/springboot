package com.pezi.demo.repository;

import com.pezi.demo.model.Mitarbeiter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Integer> {

}
