package com.projet.ecole.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.ProfesseurEntity;
import com.projet.ecole.models.ClasseMapper;
import com.projet.ecole.models.ClasseModel;
import com.projet.ecole.models.ProfesseurMapper;
import com.projet.ecole.models.ProfesseurModel;
import com.projet.ecole.services.ClasseService;
import com.projet.ecole.services.ProfesseurService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/professeur")
public class ProfesseurController {

    private static final Logger log = LoggerFactory.getLogger(ProfesseurController.class);

    @Autowired
    private ProfesseurService professeurService;

    @Autowired
    private ClasseService classeService;    
    
    @GetMapping
    public List<ProfesseurModel> obtenirProfesseurs() {
        List<ProfesseurEntity> professeurs = professeurService.obtenirProfesseurs();
        return ProfesseurMapper.transformerProfesseurs(professeurs);
    }

    @GetMapping("/{id}")
    public ProfesseurModel obtenirProfesseur(@PathVariable Integer id) {
        ProfesseurEntity professeur = professeurService.obtenirProfesseur(id);
        ProfesseurModel professeurModel = ProfesseurMapper.transformerProfesseur(professeur);
        return professeurModel;
    }  
    
    @GetMapping("/{id}/classes")
    public List<ClasseModel> obtenirProfesseurClasses(@PathVariable Integer id) {
        List<ClasseEntity> classes = classeService.obtenirProfesseurClasses(id);
        return ClasseMapper.transformerClasses(classes);
    }      
    
    @PostMapping()
    public ProfesseurModel creerProfesseur(@RequestBody ProfesseurModel professeurModel) {
        log.info("");
        log.info("professeur = " + professeurModel.getNom());
        log.info("professeur = " + professeurModel.getClasses());
        return professeurService.creerProfesseur(professeurModel);
    }

    @PostMapping("/{id}")
    public ProfesseurModel modifierProfesseur(@PathVariable Integer id, @RequestBody ProfesseurModel professeurModel) {
        ProfesseurModel professeurModifie = professeurService.modifierProfesseur(id, professeurModel);
        return professeurModifie;
    }
    
    @DeleteMapping()
    public void retirerClasse(@RequestParam Integer numero, @RequestParam Integer classe) {
        professeurService.retirerClasse(numero, classe);
    }
    
}
