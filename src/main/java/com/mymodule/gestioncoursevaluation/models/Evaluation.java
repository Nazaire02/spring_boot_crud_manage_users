package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String Labelle;

    @Column(nullable = false)
    private Date date_evaluation;

    @Column(nullable = false)
    private String heure_debut;

    @Column(nullable = false)
    private String heure_fin;

    private String statut;

    @OneToMany(mappedBy = "evaluation")
    private List<Feuille> feuilles;

    @OneToMany(mappedBy = "evaluation")
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "idClasse")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "idEnseignant")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "idEcue")
    private ECUE ecue;
}
