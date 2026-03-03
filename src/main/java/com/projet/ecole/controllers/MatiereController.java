package com.projet.ecole.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ecole.entities.MatiereEntity;
import com.projet.ecole.entities.ProfesseurEntity;
import com.projet.ecole.models.MatiereModel;
import com.projet.ecole.models.ProfesseurMapper;
import com.projet.ecole.models.ProfesseurModel;
import com.projet.ecole.models.MatiereMapper;
import com.projet.ecole.services.MatiereService;
import com.projet.ecole.services.ProfesseurService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/matiere")
public class MatiereController {

    private static final Logger log = LoggerFactory.getLogger(MatiereController.class);

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private ProfesseurService professeurService;    

    @GetMapping
    public List<MatiereModel> obtenirMatieres() {
        List<MatiereEntity> matieres = matiereService.obtenirMatieres();
        List<MatiereModel> matiereModels = MatiereMapper.transformerMatieres(matieres);
        return matiereModels;
    }

    @GetMapping("/{id}")
    public MatiereModel obtenirMatiere(@PathVariable Integer id) {
        MatiereEntity matiere = matiereService.obtenirMatiere(id);    
        MatiereModel matiereModel = MatiereMapper.transformerMatiere(matiere);
        return matiereModel;
    }  

    @GetMapping("/{id}/professeurs")
    public List<ProfesseurModel> obtenirMatiereProfesseurs(@PathVariable Integer id) {
        List<ProfesseurEntity> professeurs = professeurService.obtenirMatiereProfesseurs(id);
        return ProfesseurMapper.transformerProfesseurs(professeurs);
    }
    
    
    @PostMapping()
    public MatiereModel creerMatiere(@RequestBody MatiereEntity matiere) {
        log.info("Recu depuis Angular = " + matiere.getNom());
        MatiereEntity nouvelleMatiere = matiereService.creerMatiere(matiere); 
        return MatiereMapper.transformerMatiere(nouvelleMatiere);
    }
}
