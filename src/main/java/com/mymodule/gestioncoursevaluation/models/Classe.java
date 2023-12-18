package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    //@ManyToMany()
    //@JoinTable(
     //       name = "enseignant_classe",
    //        joinColumns = @JoinColumn(name = "classe_id"),
    //        inverseJoinColumns = @JoinColumn(name = "enseignant_id")
    //)
    //private Set<Enseignant> enseignant = new HashSet<>();
}
