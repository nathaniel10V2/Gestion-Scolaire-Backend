package com.projet.ecole.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecole.entities.AbsenceEntity;
import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.EleveEntity;
import com.projet.ecole.models.ClasseMapper;
import com.projet.ecole.models.EleveMapper;
import com.projet.ecole.models.EleveModel;
import com.projet.ecole.repositories.EleveRepository;

@Service
public class EleveService {

    private static final Logger log = LoggerFactory.getLogger(EleveService.class); 

    @Autowired
    private EleveRepository eleveRepository;   
    
    @Autowired
    private ClasseService classeService;

    @Autowired
    private AbsenceService absenceService; 

    public EleveModel creerEleve(EleveModel eleveModel) {
        log.info("ClasseModel ID = " + eleveModel.getClasseModel().getId());
        EleveEntity eleve = EleveMapper.transformerEleveModel(eleveModel);
        log.info("");
        log.info("EleveModel nom = " + eleveModel.getNom());    
        eleveRepository.save(eleve);
        eleveModel.setId(eleve.getId());
        return eleveModel;
    }

    public List<EleveEntity> obtenirEleves() {
        return eleveRepository.findAll();
    }

    public EleveEntity obtenirEleve(Integer id) {
        return eleveRepository.findById(id).get();
    }    

    public List<EleveEntity> obtenirClasseEleves(Integer id) {
        ClasseEntity classe = classeService.obtenirClasse(id);
        return eleveRepository.findByClasse(classe);
    } 

    public List<AbsenceEntity> obtenirAbsences(Integer id) {
        EleveEntity eleve = obtenirEleve(id);
        List<AbsenceEntity> absences = absenceService.obtenirEleveAbsences(eleve);
        return absences;
    }    
    
    public EleveModel modifiEleve(Integer id, EleveModel eleveModel) {
        EleveEntity eleve = eleveRepository.findById(id).get();
        if (eleve != null) {
            if (!eleveModel.getNom().isEmpty()) {
                eleve.setNom(eleveModel.getNom());
            }
            if (!eleveModel.getPrenom().isEmpty()) {
                eleve.setPrenom(eleveModel.getPrenom());
            }
            if (!eleveModel.getAdresse().isEmpty()) {
                eleve.setAdresse(eleveModel.getAdresse());
            }
            if (eleveModel.getClasseModel() != null) {
                ClasseEntity classe = ClasseMapper.transformerClasseModel(eleveModel.getClasseModel());
                eleve.setClasse(classe);
            }
            eleveRepository.save(eleve);
        }
        return EleveMapper.transformerEleve(eleve);
    }

    public void supprimerEleve(Integer id) {
        eleveRepository.deleteById(id);
    }
}
