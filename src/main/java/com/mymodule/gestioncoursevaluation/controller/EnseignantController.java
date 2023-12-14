package com.mymodule.gestioncoursevaluation.controller;

import com.mymodule.gestioncoursevaluation.models.Classe;
import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.repository.EnseignantRepository;
import com.mymodule.gestioncoursevaluation.services.ClasseService;
import com.mymodule.gestioncoursevaluation.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;

@Controller
public class EnseignantController {
    @Autowired private EnseignantService es;
    @Autowired private ClasseService cs;

    @GetMapping("/enseignants")
    public String enseignantListe(Model model){
        List<Enseignant> allEnseignant = es.allEnseignants();
        model.addAttribute("enseignants", allEnseignant);
        return "screems/enseignants/enseignants";
    }

    @GetMapping("/enseignant/new")
    public String showNewForm(Model model){
        model.addAttribute("pageTitle", "Renseigner les informations de l'enseignant");
        model.addAttribute("enseignant", new Enseignant());
        model.addAttribute("classes", cs.classeListe());
        return "screems/enseignants/form_enseignant";
    }

    @PostMapping("/enseignant/add")
    public String addEnseignant(Enseignant enseignant, @RequestParam("classeIds") List<Integer> classeIds){
        List<Classe> classesSelectionnees = cs.classeListByIds(classeIds);
        enseignant.getClasses().addAll(classesSelectionnees);
        for (Classe classe:
                classesSelectionnees) {
            System.out.println(classe);
        }
        enseignant.setClasses(new HashSet<>(classesSelectionnees));
        es.save(enseignant);
        return "redirect:/enseignants";
    }

    @GetMapping("/edit/enseignant/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        Enseignant enseignant = es.getEnseignant(id);
        model.addAttribute("pageTitle", "Modifier les informations de votre choix");
        model.addAttribute("enseignant", enseignant);
        return "screems/enseignants/form_enseignant";
    }

    @GetMapping("/delete/enseignant/{id}")
    public String deleteEnseignant(@PathVariable("id") Integer id){
        es.delete(id);
        return "redirect:/enseignants";
    }
}
