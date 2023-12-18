package com.mymodule.gestioncoursevaluation.services;

import com.mymodule.gestioncoursevaluation.models.*;
import com.mymodule.gestioncoursevaluation.repository.EcueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcueService {
    @Autowired private EcueRepository ecueRepository;

    public List<ECUE> ecueListe(){
        return (List<ECUE>) ecueRepository.findAll();
    }

    public void save(ECUE ecue){
        //enseignant.setPassword("Enseignant2023");
        //enseignant.setMatricule("AZERTY");
        ecueRepository.save(ecue);
    }

    public List<ECUE> ecueListByIds(Iterable<Integer> ids){
        return (List<ECUE>) ecueRepository.findAllById(ids);
    }
}
