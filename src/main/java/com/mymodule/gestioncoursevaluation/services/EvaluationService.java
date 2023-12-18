package com.mymodule.gestioncoursevaluation.services;

import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.models.Evaluation;
import com.mymodule.gestioncoursevaluation.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {
    @Autowired private EvaluationRepository evaluationRepository;

    public Evaluation getEvaluation(Integer id){
        Optional<Evaluation> evaluation = evaluationRepository.findById(id);
        return evaluation.get();
    }
    public List<Evaluation> allEvaluations(){
        return (List<Evaluation>) evaluationRepository.findAll();
    }
    public void save(Evaluation evaluation){
        //enseignant.setPassword("Enseignant2023");
        //enseignant.setMatricule("AZERTY");
        evaluationRepository.save(evaluation);
    }

    public void delete(Integer id){
        evaluationRepository.deleteById(id);
    }

}
