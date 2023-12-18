package com.mymodule.gestioncoursevaluation.controller;

import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.models.Etudiant;
import com.mymodule.gestioncoursevaluation.models.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {
    @GetMapping("/index/enseignant")
    public String mainEnseignant(Model model, @ModelAttribute("enseignantLog")Enseignant enseignantLog){
        model.addAttribute("isAdmin", false);
        System.out.println(enseignantLog);
        return "screems/index";
    }

    @GetMapping("/index/etudiant")
    public String mainEtudiant(Model model, @ModelAttribute("etudiantLog") Etudiant etudiantLog){
        model.addAttribute("isAdmin", false);
        System.out.println(etudiantLog);
        return "screems/index";
    }

    @GetMapping("")
    public String login(Model model){
        model.addAttribute("loginData", new Login());
        return "screems/login";
    }
}
