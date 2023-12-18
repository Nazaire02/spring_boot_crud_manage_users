package com.mymodule.gestioncoursevaluation.controller;

import com.mymodule.gestioncoursevaluation.GlobalVariables;
import com.mymodule.gestioncoursevaluation.models.Cours;
import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.models.Etudiant;
import com.mymodule.gestioncoursevaluation.services.ClasseService;
import com.mymodule.gestioncoursevaluation.services.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CoursController {
    @Autowired private CoursService coursService;
    @Autowired private ClasseService cs;
    @GetMapping("/cours")
    public String enseignantListe(Model model){
        List<Cours> allCours = coursService.allCours();
        model.addAttribute("cours", allCours);
        model.addAttribute("isAdmin", false);
        return "screems/cours/cours";
    }

    @GetMapping("/cours/new")
    private String showNewForm(Model model){
        model.addAttribute("cours", new Cours());
        model.addAttribute("isAdmin", false);
        model.addAttribute("classes", cs.classeListe());
        model.addAttribute("pageTitle","Renseigner les infos du cours dans le formulaire ci dessous");
        return "screems/cours/form_cours";
    }

    @PostMapping("/cours/add")
    private String addCours(Cours cours){
        //cours.setEnseignant(globalVariables);
        coursService.save(cours);
        return "redirect:/cours";
    }

    @GetMapping("/edit/cours/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        Cours cours = coursService.getCours(id);
        model.addAttribute("classes", cs.classeListe());
        model.addAttribute("pageTitle", "Modifier les informations de votre choix");
        model.addAttribute("cours", cours);
        return "screems/cours/form_cours_edit";
    }

    @GetMapping("/delete/cours/{id}")
    private String deleteEtudiant(@PathVariable("id") Integer id, Model model){
        coursService.delete(id);
        return "redirect:/cours";
    }
}
