package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "classe")
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "classe")
    private List<Cours> cours;

    @OneToMany(mappedBy = "classe")
    private List<Fichier> fichiers;
}
