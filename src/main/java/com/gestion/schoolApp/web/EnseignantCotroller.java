package com.gestion.schoolApp.web;

import com.gestion.schoolApp.dao.EnseignantRepository;
import com.gestion.schoolApp.entities.Enseignants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class EnseignantCotroller {
    @Autowired
    private EnseignantRepository enseignantRepository;

    @GetMapping(path ="/enseignants")
    public String enseignant(Model model,
    @RequestParam(name ="page",defaultValue = "0")int page,
    @RequestParam(name ="size",defaultValue = "5")int size,
    @RequestParam(name ="motcle",defaultValue = "")String motcle
    ){
        Page<Enseignants> pageEns= enseignantRepository.findByNomEnContains(motcle,PageRequest.of(page, size));
        model.addAttribute("pageEnseignants", pageEns);
        model.addAttribute("currentpage", page);
        model.addAttribute("size",size);
        model.addAttribute("pages", new int[pageEns.getTotalPages()]);
        model.addAttribute("motcle",motcle);
        return "enseignants";
    }

    @GetMapping(path = "/deleteEnseignant")
    public String delete(Long id,String motcle,String page,String size){
        enseignantRepository.deleteById(id);
        return "redirect:/ensegnants?page="+page+"&motcle="+motcle+"&size="+size;
    }
}
