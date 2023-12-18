package com.mymodule.gestioncoursevaluation.services;

import com.mymodule.gestioncoursevaluation.models.Cours;
import com.mymodule.gestioncoursevaluation.models.ECUE;
import com.mymodule.gestioncoursevaluation.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {
    @Autowired private CoursRepository<ECUE, Number> coursRepository;

    public Cours getCours(Integer id){
        Optional<Cours> cours = coursRepository.findById(id);
        return cours.get();
    }
    public List<Cours> allCours(){
        return (List<Cours>) coursRepository.findAll();
    }
    public void save(Cours cours){
        //enseignant.setPassword("Enseignant2023");
        //enseignant.setMatricule("AZERTY");
        coursRepository.save(cours);
    }

    public void delete(Integer id){
        coursRepository.deleteById(id);
    }

}
