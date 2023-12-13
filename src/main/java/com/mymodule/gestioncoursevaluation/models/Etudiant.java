package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(unique = true, nullable = false)
    //remettre unique true after
    @Column(nullable = false)
    private String matricule;

    @Column(length = 30, nullable = false)
    private String nom;

    @Column(length = 70, nullable = false)
    private String prenoms;

    //@Column(unique = true, nullable = false)
    //remettre unique true after
    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 20)
    private String telephone;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "idClasse")
    private Classe classe;

    @OneToMany(mappedBy = "etudiant")
    private List<Feuille> feuilles;
}
