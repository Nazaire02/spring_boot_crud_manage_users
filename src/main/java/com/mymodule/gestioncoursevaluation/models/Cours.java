package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date date_cours;

    @Column(nullable = false)
    private String heure_debut;

    @Column(nullable = false)
    private String heure_fin;

    @Column(nullable = false)
    private String lien_meet;

    @ManyToOne
    @JoinColumn(name = "idClasse")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "idEnseignant")
    private Enseignant enseignant;
}
