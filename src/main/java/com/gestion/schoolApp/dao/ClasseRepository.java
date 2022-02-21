package com.gestion.schoolApp.dao;

import com.gestion.schoolApp.entities.Classes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classes,Long> {
    
}
