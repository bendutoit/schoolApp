package com.gestion.schoolApp.web;

import java.util.List;

import com.gestion.schoolApp.dao.ClasseRepository;
import com.gestion.schoolApp.entities.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClasseController {
    @Autowired
    private ClasseRepository classeRepository;

    @GetMapping(path = "/classes")
    public String afficheClasse(Model model){
List<Classes> listClasse=classeRepository.findAll();
model.addAttribute("listClasse", listClasse);
        return "classes_list";
    }

    @GetMapping(path ="/classes/new")
    public String shownewEleveform(Model model){
        
        model.addAttribute("classes", new Classes());
    
    return "classe_form";
    }

    @PostMapping(path ="/classes/save")
    public String saveClasse(Classes clas){  
     classeRepository.save(clas) ;
    return "redirect:/classes";
    }
    
}
