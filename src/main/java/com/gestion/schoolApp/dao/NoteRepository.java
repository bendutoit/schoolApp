package com.gestion.schoolApp.dao;

import com.gestion.schoolApp.entities.Notes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Notes,Long> {
    
}
