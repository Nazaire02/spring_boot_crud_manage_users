package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Feuille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private Float note;

    @Column(nullable = true)
    private String observation;

    private String statut;

    @ManyToOne
    @JoinColumn(name = "idEtudiant")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "idEvaluation")
    private Evaluation evaluation;
}
