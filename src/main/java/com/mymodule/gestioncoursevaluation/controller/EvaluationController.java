package com.mymodule.gestioncoursevaluation.controller;

import com.mymodule.gestioncoursevaluation.models.Cours;
import com.mymodule.gestioncoursevaluation.models.ECUE;
import com.mymodule.gestioncoursevaluation.models.Evaluation;
import com.mymodule.gestioncoursevaluation.services.ClasseService;
import com.mymodule.gestioncoursevaluation.services.CoursService;
import com.mymodule.gestioncoursevaluation.services.EcueService;
import com.mymodule.gestioncoursevaluation.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;
    @Autowired private ClasseService cs;
    @Autowired private EcueService ecueService;

    @GetMapping("/evaluations")
    public String enseignantListe(Model model){
        List<Evaluation> allEvaluations = evaluationService.allEvaluations();
        model.addAttribute("evaluations", allEvaluations);
        model.addAttribute("isAdmin", false);
        return "screems/evaluations/evaluations";
    }

    @GetMapping("/evaluations/new")
    private String showNewForm(Model model){
        model.addAttribute("evaluations", new Evaluation());
        model.addAttribute("isAdmin", false);
        model.addAttribute("classes", cs.classeListe());
        model.addAttribute("ecues", ecueService.ecueListe());
        model.addAttribute("pageTitle","Renseigner les infos de l'evaluation dans le formulaire ci dessous");
        return "screems/evaluations/form_evaluations";
    }

    @PostMapping("/evaluations/add")
    private String addEvaluation(Evaluation evaluation){
        //cours.setEnseignant(globalVariables);
        evaluationService.save(evaluation);
        return "redirect:/evaluations";
    }

    @GetMapping("/edit/evaluation/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        Evaluation evaluation = evaluationService.getEvaluation(id);
        model.addAttribute("classes", cs.classeListe());
        model.addAttribute("pageTitle", "Modifier les informations de votre choix");
        model.addAttribute("evaluations", evaluation);
        return "screems/evaluations/form_evaluation_edit";
    }

    @GetMapping("/delete/evaluation/{id}")
    private String deleteEtudiant(@PathVariable("id") Integer id, Model model){
        evaluationService.delete(id);
        return "redirect:/evaluations";
    }
}
