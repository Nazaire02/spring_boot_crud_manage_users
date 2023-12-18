package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Je dois générer un matricule unique aussi
    private String matricule;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenoms;

    @Column(unique = true, nullable = false)
    private String email;

    private String telephone;

    //Je dois générer un mot de passe par defaut
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "enseignant")
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "enseignant")
    private List<Fichier> fichiers;

    @OneToMany(mappedBy = "enseignant")
    private List<Cours> cours;

    //@ManyToMany(mappedBy = "enseignant")
    //private Set<ECUE> ecues = new HashSet<>();

    //@ManyToMany(mappedBy = "enseignant")
    //private Set<Classe> classes = new HashSet<>();
}
