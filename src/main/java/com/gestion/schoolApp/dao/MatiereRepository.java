package com.gestion.schoolApp.dao;

import com.gestion.schoolApp.entities.Matieres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matieres,Long> {
    
}
