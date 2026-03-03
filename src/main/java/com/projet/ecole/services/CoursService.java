package com.projet.ecole.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.CoursEntity;
import com.projet.ecole.entities.MatiereEntity;
import com.projet.ecole.models.CoursMapper;
import com.projet.ecole.models.CoursModel;
import com.projet.ecole.models.MatiereMapper;
import com.projet.ecole.repositories.CoursRepository;

@Service
public class CoursService {

    private static final Logger log = LoggerFactory.getLogger(CoursService.class);

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private ClasseService classeService;    

    @Autowired
    private MatiereService matiereService;     
    
    public CoursModel creerCours(CoursModel coursModel) {
        log.info("cours1 = "+ coursModel.getJour());
        log.info("cours2 = "+ coursModel.getMatiere().getNom());
        CoursEntity cours = CoursMapper.transformerUnCoursModel(coursModel);
        MatiereEntity matiere = matiereService.obtenirMatiere(coursModel.getMatiere().getId());
        coursModel.setMatiere(MatiereMapper.transformerMatiere(matiere));
        cours.setMatiere(matiere);
        coursRepository.save(cours);
        coursModel.setId(cours.getId());
        return coursModel;
    }

    private CoursEntity obtenirUnCours() {
        return coursRepository.findAll().getLast();
    }

    public void definirClasse(Integer classeId) {
        CoursEntity cours = obtenirUnCours();
        ClasseEntity classe = classeService.obtenirClasse(classeId);
        cours.setClasse(classe);
        coursRepository.save(cours);
    }

    public List<CoursEntity> obtenirCours(Integer classeId) {
        ClasseEntity classe = classeService.obtenirClasse(classeId);
        return coursRepository.findByClasse(classe);
    }      

    public List<CoursEntity> trierCours(Integer classeId) {
        List<CoursEntity> cours = obtenirCours(classeId);
        List<String> joursOrdres = List.of("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi");
        List<String> periodesOrdres = List.of("Matin", "Après-Midi");

        if (cours != null) {
            Comparator<CoursEntity> coursComparator = Comparator
                .comparing((CoursEntity c) -> joursOrdres.indexOf(c.getJour()))
                .thenComparing(c -> periodesOrdres.indexOf(c.getPeriode()));

            Collections.sort(cours, coursComparator);
        }
        log.info("cours = ", cours);
        return cours;
    }

    public CoursModel modifierCours(Integer id, CoursModel coursModel) {
        CoursEntity cours = coursRepository.findById(id).get();

        if (coursModel != null) {
            if (coursModel.getMatiere() != null) {
                MatiereEntity matiere = matiereService.obtenirMatiere(coursModel.getMatiere().getId());
                cours.setMatiere(matiere);                
            }
            if (coursModel.getPeriode() != null || coursModel.getPeriode().isEmpty()) {
                cours.setPeriode(coursModel.getPeriode());
            }
            if (coursModel.getJour() != null || coursModel.getJour().isEmpty()) {
                cours.setJour(coursModel.getJour());
            }  
            log.info("cours = ", cours);
            coursRepository.save(cours);          
        }

        return coursModel;
    }
}
