package com.projet.ecole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ecole.entities.CoursEntity;
import com.projet.ecole.models.CoursMapper;
import com.projet.ecole.models.CoursModel;
import com.projet.ecole.services.CoursService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;   
    
    @PostMapping
    public CoursModel creerCours(@RequestBody CoursModel coursModel, @RequestParam Integer classe) {
        CoursModel nouveauCours = coursService.creerCours(coursModel);
        coursService.definirClasse(classe);
        return nouveauCours;
    }  
    
    @PostMapping("/{id}")
    public CoursModel modifierCours(@PathVariable Integer id, @RequestBody CoursModel coursModel) {
        return coursService.modifierCours(id, coursModel);
    }
    
    @PostMapping("/trier")
    public List<CoursModel> trierCours(@RequestParam Integer classeId) {
        List<CoursEntity> coursList = coursService.trierCours(classeId);
        List<CoursModel> coursModels = CoursMapper.transformerPlusieursCours(coursList);
        return coursModels;
    }
    
}
