package com.gestion.schoolApp.dao;


import com.gestion.schoolApp.entities.Eleves;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EleveRepository extends JpaRepository<Eleves,Long> {
 public Page<Eleves> findByNomElvContains(String mc,Pageable pageable);


 @Query("select e from Eleves e where e.nomElv like :x")
 public Page<Eleves> chercher(
     @Param("x")String mc,
     Pageable pageable);
     
     
}
