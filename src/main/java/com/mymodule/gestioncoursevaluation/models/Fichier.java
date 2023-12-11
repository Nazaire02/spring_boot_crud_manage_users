package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Fichier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;

    @Column(nullable = false)
    private String urlfichier;

    @Column(nullable = false)
    private String namefichier;

    @ManyToOne
    @JoinColumn(name = "idClasse")
    private  Classe classe;

    @ManyToOne
    @JoinColumn(name = "idEnseignant")
    private  Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "idEcue")
    private  ECUE ecue;
}
