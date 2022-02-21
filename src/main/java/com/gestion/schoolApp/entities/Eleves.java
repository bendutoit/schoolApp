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
public class Eleves {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEleves;
    private String matriculeEl;
   private String nomElv;
   private String photoEl;
   private String prenomEl;
   private String sexeEl;
   private String quartierEl;
   private String dateNais;
  
    @JsonIgnore
   @XmlTransient
   @OneToMany(mappedBy="eleves",fetch=FetchType.LAZY)
   private Collection<Notes> notes;
   @ManyToOne    
    @JoinColumn(name="idClasses")
    private Classes classes;


}
