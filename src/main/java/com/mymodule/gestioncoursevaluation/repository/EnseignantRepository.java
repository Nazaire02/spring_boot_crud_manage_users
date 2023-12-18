package com.mymodule.gestioncoursevaluation.repository;

import com.mymodule.gestioncoursevaluation.models.Enseignant;
import org.springframework.data.repository.CrudRepository;

public interface EnseignantRepository extends CrudRepository<Enseignant, Integer> {
    Enseignant findByEmail(String email);
}
