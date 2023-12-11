package com.mymodule.gestioncoursevaluation.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private Number points;

    @Column(nullable = false)
    private String reponse_juste;

    @Column(nullable = false)
    private String reponse_fasse_1;

    private String reponse_fasse_2;

    private String reponse_fasse_3;

    @ManyToOne
    @JoinColumn(name = "idEvaluation")
    private Evaluation evaluation;

}
