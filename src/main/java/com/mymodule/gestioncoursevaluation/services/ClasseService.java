package com.mymodule.gestioncoursevaluation.services;

import com.mymodule.gestioncoursevaluation.models.Classe;
import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {
    @Autowired private ClasseRepository cr;

    public List<Classe> classeListe(){
        return (List<Classe>) cr.findAll();
    }
}
