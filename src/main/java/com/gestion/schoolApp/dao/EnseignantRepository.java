package com.gestion.schoolApp.dao;

import com.gestion.schoolApp.entities.Enseignants;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignants,Long> {
    public Page<Enseignants> findByNomEnContains(String mc,Pageable pageable);
}
