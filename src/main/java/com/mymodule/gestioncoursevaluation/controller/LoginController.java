package com.mymodule.gestioncoursevaluation.controller;

import com.mymodule.gestioncoursevaluation.GlobalVariables;
import com.mymodule.gestioncoursevaluation.models.Enseignant;
import com.mymodule.gestioncoursevaluation.models.Etudiant;
import com.mymodule.gestioncoursevaluation.models.Login;
import com.mymodule.gestioncoursevaluation.services.EnseignantService;
import com.mymodule.gestioncoursevaluation.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @Autowired private EtudiantService etudiantService;
    @Autowired private EnseignantService enseignantService;
    @Autowired public GlobalVariables globalVariables;

    @GetMapping("/login")
    private String Login(Login loginData, Model model, RedirectAttributes ra){
        Enseignant enseignantLog;
        Etudiant etudiantLog;
        if (loginData.getUsertype().equals("enseignant")){
            globalVariables.setEnseignantLog(enseignantService.findByEmail(loginData.getEmail()));
            if (globalVariables.getEnseignantLog() != null){
                if (loginData.getPassword().equals(globalVariables.getEnseignantLog().getPassword())){
                    model.addAttribute("isAdmin", false);
                    ra.addAttribute("enseignantLog", globalVariables.getEnseignantLog());
                    return "redirect:/index/enseignant";
                }
            }
        } else if (loginData.getUsertype().equals("etudiant")) {
            globalVariables.setEtudiantLog(etudiantService.findByEmail(loginData.getEmail()));
            etudiantLog = globalVariables.getEtudiantLog();
            if (etudiantLog != null){
                if (loginData.getPassword().equals(etudiantLog.getPassword())){
                    System.out.println(globalVariables.getEnseignantLog());
                    model.addAttribute("isAdmin", false);
                    ra.addAttribute("etudiantLog", etudiantLog);
                    return "redirect:/index/etudiant";
                }
            }
        }

        model.addAttribute("loginData", new Login());
        return "/screems/login";
    }
}
