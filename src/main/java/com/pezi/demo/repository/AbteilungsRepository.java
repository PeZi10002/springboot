package com.pezi.demo.repository;

import com.pezi.demo.model.Abteilung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbteilungsRepository extends JpaRepository<Abteilung, Integer> {

}
