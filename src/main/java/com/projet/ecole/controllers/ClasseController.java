package com.projet.ecole.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.CoursEntity;
import com.projet.ecole.entities.EleveEntity;
import com.projet.ecole.entities.MatiereEntity;
import com.projet.ecole.entities.ProfesseurEntity;
import com.projet.ecole.models.ClasseMapper;
import com.projet.ecole.models.ClasseModel;
import com.projet.ecole.models.CoursMapper;
import com.projet.ecole.models.CoursModel;
import com.projet.ecole.models.EleveMapper;
import com.projet.ecole.models.EleveModel;
import com.projet.ecole.models.MatiereMapper;
import com.projet.ecole.models.MatiereModel;
import com.projet.ecole.models.ProfesseurMapper;
import com.projet.ecole.models.ProfesseurModel;
import com.projet.ecole.services.ClasseService;
import com.projet.ecole.services.CoursService;
import com.projet.ecole.services.EleveService;
import com.projet.ecole.services.MatiereService;
import com.projet.ecole.services.ProfesseurService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/classe")
public class ClasseController {

    private static final Logger log = LoggerFactory.getLogger(ClasseController.class);
    
    @Autowired
    private ClasseService classeService;

    @Autowired
    private CoursService coursService;

    @Autowired
    private ProfesseurService professeurService;

    @Autowired
    private EleveService eleveService;  
    
    @Autowired
    private MatiereService matiereService;    

    @GetMapping
    public List<ClasseModel> obtenirClasses() {
        List<ClasseEntity> classes = classeService.obtenirClasses(); 
        return ClasseMapper.transformerClasses(classes);
    }
    
    @GetMapping("/{id}")
    public ClasseModel obtenirClasses(@PathVariable Integer id) {
        ClasseEntity classe = classeService.obtenirClasse(id); 
        return ClasseMapper.transformerClasse(classe);
    }

    @GetMapping("/{id}/professeurs")
    public List<ProfesseurModel> obtenirClasseProfesseurs(@PathVariable Integer id) {
        List<ProfesseurEntity> professeurs = professeurService.obtenirClasseProfesseurs(id);
        return ProfesseurMapper.transformerProfesseurs(professeurs);
    }

    @GetMapping("/{id}/eleves")
    public List<EleveModel> obtenirClasseEleves(@PathVariable Integer id) {
        List<EleveEntity> eleves = eleveService.obtenirClasseEleves(id);
        return EleveMapper.transformerEleves(eleves);
    }

    @GetMapping("/{id}/matieres")
    public List<MatiereModel> obtenirMatieres(@PathVariable Integer id) {
        List<MatiereEntity> matieres = matiereService.obtenirMatieres(id);
        return MatiereMapper.transformerMatieres(matieres);
    }       
    
    @GetMapping("/{id}/cours")
    public List<CoursModel> obtenirCours(@PathVariable Integer id) {
        List<CoursEntity> cours = coursService.obtenirCours(id);
        if (cours.size() > 0) {
            log.info("matieres = "+ cours.get(0).getMatiere().getNom());            
        }
        return CoursMapper.transformerPlusieursCours(cours);
    }    

    @PostMapping
    public ClasseModel creerClasse(@RequestBody ClasseEntity classe) {
        ClasseEntity nouvelleClasse = classeService.creerClasse(classe);
        return ClasseMapper.transformerClasse(nouvelleClasse);
    }
    
    @DeleteMapping
    public void retirerProfesseur(@RequestParam Integer numero, @RequestParam Integer professeur) {
        classeService.retirerProfesseur(numero, professeur);
    }
}
