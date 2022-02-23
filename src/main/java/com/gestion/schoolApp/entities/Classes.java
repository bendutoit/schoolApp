package com.gestion.schoolApp.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Classes {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long idClasses;
   @Column(unique = true)
   private String codeclasses;
  @JsonIgnore
 @XmlTransient 
   @OneToMany(mappedBy="classes",fetch=FetchType.LAZY)
   private Collection<Eleves> eleves;
}
