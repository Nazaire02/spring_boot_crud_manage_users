package com.mymodule.gestioncoursevaluation.controller;

import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.models.Etudiant;
import com.mymodule.gestioncoursevaluation.services.ClasseService;
import com.mymodule.gestioncoursevaluation.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EtudiantController {
    @Autowired private EtudiantService es;
    @Autowired private ClasseService cs;
    @GetMapping("/etudiants")
    private String etudiantListe(Model model){
        model.addAttribute("etudiants", es.allEtudiants());
        return "/screems/etudiants/etudiants";
    }

    @GetMapping("/etudiant/new")
    private String showNewForm(Model model){
        model.addAttribute("etudiant", new Etudiant());
        model.addAttribute("classes", cs.classeListe());
        model.addAttribute("pageTitle","Renseigner les infos de l'étudiant dans le formulaire ci dessous");
        return "screems/etudiants/form_etudiant";
    }

    @PostMapping("/etudiant/add")
    private String addEtudiant(Etudiant etudiant){
        es.save(etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/edit/etudiant/{id}")
    private String editEtudiant(@PathVariable("id") Integer id, Model model){
        model.addAttribute("etudiant", es.getEtudiant(id));
        model.addAttribute("pageTitle","Modifier les infos de l'étudiant dans le formulaire ci dessous");
        return "screems/etudiants/form_etudiant";
    }

    @GetMapping("/delete/etudiant/{id}")
    private String deleteEtudiant(@PathVariable("id") Integer id, Model model){
        es.delete(id);
        return "redirect:/etudiants";
    }
}
