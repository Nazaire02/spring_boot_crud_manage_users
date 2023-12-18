package com.mymodule.gestioncoursevaluation.repository;

import com.mymodule.gestioncoursevaluation.models.Cours;
import org.springframework.data.repository.CrudRepository;

public interface CoursRepository<E, I extends Number> extends CrudRepository<Cours, Integer> {
}
