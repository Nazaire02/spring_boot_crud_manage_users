package com.mymodule.gestioncoursevaluation.services;

import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepository er;

    public Enseignant getEnseignant(Integer id){
        Optional<Enseignant> enseignant = er.findById(id);
        return enseignant.get();
    }
    public List<Enseignant> allEnseignants(){
        return (List<Enseignant>) er.findAll();
    }
    public void save(Enseignant enseignant){
        enseignant.setPassword("Enseignant2023");
        enseignant.setMatricule("AZERTY");
        er.save(enseignant);
    }

    public Enseignant findByEmail(String email){
        return er.findByEmail(email);
    }

    public void delete(Integer id){
        er.deleteById(id);
    }

}
