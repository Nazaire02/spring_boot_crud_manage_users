package com.mymodule.gestioncoursevaluation.services;

import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.models.Etudiant;
import com.mymodule.gestioncoursevaluation.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    @Autowired private EtudiantRepository er;

    public List<Etudiant> allEtudiants(){
        return (List<Etudiant>) er.findAll();
    }

    public Etudiant getEtudiant(Integer id){
        Optional<Etudiant> etudiant = er.findById(id);
        return etudiant.get();
    }

    public void save(Etudiant etudiant){
        etudiant.setMatricule("ETUD0012");
        etudiant.setPassword("PASSWORD123");
        er.save(etudiant);
    }

    public void delete(Integer id){
        er.deleteById(id);
    }

}
