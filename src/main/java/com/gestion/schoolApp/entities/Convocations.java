package com.gestion.schoolApp.entities;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;
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
public class Convocations {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long idConvocations;
    private String objets;
    private String libelles;
    private String heures;
    private Date dates;
}
