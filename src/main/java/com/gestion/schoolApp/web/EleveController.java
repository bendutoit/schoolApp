package com.gestion.schoolApp.web;



import java.util.List;

import javax.persistence.Id;

import com.gestion.schoolApp.dao.ClasseRepository;
import com.gestion.schoolApp.dao.EleveRepository;
import com.gestion.schoolApp.entities.Classes;
import com.gestion.schoolApp.entities.Eleves;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EleveController {

    @Autowired
    private EleveRepository eleveRepository;
    @Autowired
    private ClasseRepository classeRepository;
    @GetMapping(path = "/index")
    public String index(){
        return "index";
    }

    @GetMapping(path ="/eleves")
    public String eleve(Model model,
    @RequestParam(name ="page",defaultValue = "0")int page,
    @RequestParam(name ="size",defaultValue = "5")int size,
    @RequestParam(name ="motcle",defaultValue = "")String motcle
    ){
        Page<Eleves> pageelvs= eleveRepository.findByNomElvContains(motcle,PageRequest.of(page, size));
        model.addAttribute("pageEleves", pageelvs);
        model.addAttribute("currentpage", page);
        model.addAttribute("size",size);
        model.addAttribute("pages", new int[pageelvs.getTotalPages()]);
        model.addAttribute("motcle",motcle);
        return "eleves";
    }
    @GetMapping(path = "/deleteEleve")
    public String delete(Long id,String motcle,String page,String size){
        eleveRepository.deleteById(id);
        return "redirect:/eleves?page="+page+"&motcle="+motcle+"&size="+size;
    }

    @GetMapping(path ="/eleves/new")
    public String shownewEleveform(Model model){
        List<Classes> listclasses= classeRepository.findAll();
        model.addAttribute("listclasses", listclasses);
        model.addAttribute("eleves", new Eleves());
       
    return "eleve_form";
    }


    @PostMapping(path ="/eleves/save")
    public String saveEleve(Eleves elev){  
     eleveRepository.save(elev) ;
    return "redirect:/eleves";
    }

    @GetMapping(path ="/eleves/edit/{id}")
    public String showEditEleveform(@PathVariable("id") Long idEleves, Model model){
         Eleves eleves= eleveRepository.findById(idEleves).get();
        model.addAttribute("eleves", eleves);
         List<Classes> listclasses= classeRepository.findAll();
         model.addAttribute("listclasses", listclasses);
       
       return "eleve_form";
    } 

}
