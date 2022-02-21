package com.gestion.schoolApp.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Matieres {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idMatiere;
    private String codeMat;
    private Double coef;
    private String appreciation;
    private String libelleMat;

    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy="matieres",fetch=FetchType.LAZY)
    private Collection<Notes> notes;
   
    @ManyToOne    
    @JoinColumn(name="idEnseignants")
    private Enseignants enseignants;
}
