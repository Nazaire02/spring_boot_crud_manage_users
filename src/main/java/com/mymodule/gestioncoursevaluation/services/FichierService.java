package com.mymodule.gestioncoursevaluation.services;

import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.models.Fichier;
import com.mymodule.gestioncoursevaluation.repository.FichierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichierService {
    @Autowired private FichierRepository fichierRepository;

    public Fichier getFichier(Integer id){
        Optional<Fichier> fichier = fichierRepository.findById(id);
        return fichier.get();
    }
    public List<Fichier> allFichier(){
        return (List<Fichier>) fichierRepository.findAll();
    }
    public void save(Fichier fichier){
        //enseignant.setPassword("Enseignant2023");
        //enseignant.setMatricule("AZERTY");
        fichierRepository.save(fichier);
    }

    public void delete(Integer id){
        fichierRepository.deleteById(id);
    }

}
