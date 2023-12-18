package com.mymodule.gestioncoursevaluation.repository;

import com.mymodule.gestioncoursevaluation.models.Evaluation;
import org.springframework.data.repository.CrudRepository;

public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {
}
