package com.gestion.schoolApp.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idNotes;
    private Double valeurnote;
    @ManyToOne    
    @JoinColumn(name="idEleves")
    private Eleves eleves;
    @ManyToOne    
    @JoinColumn(name="idMatieres")
    private Matieres matieres;
    
}
