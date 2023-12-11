package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class ECUE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private String code;

    @OneToMany(mappedBy = "ecue")
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "ecue")
    private List<Fichier> fichiers;

    @ManyToMany()
    @JoinTable(
            name = "enseignant_ecue",
            joinColumns = @JoinColumn(name = "ecue_id"),
            inverseJoinColumns = @JoinColumn(name = "enseignant_id")
    )
    private Set<Enseignant> enseignant = new HashSet<>();
}
