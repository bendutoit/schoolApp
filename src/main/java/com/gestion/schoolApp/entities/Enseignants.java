package com.gestion.schoolApp.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Enseignants {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long idEnseignants;

    private String matriculeEn;
    private String nomEn;
    private String prenomEn;
    private String sexeEn;
    private String quartierEn;
    private String gradeEn;
    private String ancienite; 
    private Date dateNais;
    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy="enseignants",fetch=FetchType.LAZY)
    private Collection<Matieres> matieres;

}
