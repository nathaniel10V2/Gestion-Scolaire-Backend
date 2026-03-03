package com.projet.ecole.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecole.entities.AbsenceEntity;
import com.projet.ecole.entities.EleveEntity;
import com.projet.ecole.models.AbsenceMapper;
import com.projet.ecole.models.AbsenceModel;
import com.projet.ecole.repositories.AbsenceRepository;
import com.projet.ecole.repositories.EleveRepository;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private EleveRepository eleveRepository;      

    public AbsenceModel creerAbsence(AbsenceModel absenceModel, Integer eleveId) {
        EleveEntity eleve = eleveRepository.findById(eleveId).get();
        if (eleve != null) {
            AbsenceEntity absence = AbsenceMapper.transformerAbsenceModel(absenceModel);
            absence.setEleve(eleve);
            absenceRepository.save(absence);
            absenceModel.setId(absence.getId());            
        }
        return absenceModel;
    }

    public List<AbsenceEntity> obtenirEleveAbsences(EleveEntity eleve) {
        return absenceRepository.findByEleve(eleve);
    }

    public List<AbsenceEntity> trierAbsences(Integer eleveId) {
        List<AbsenceEntity> absences = new ArrayList<>();
        EleveEntity eleve = eleveRepository.findById(eleveId).get();
        if (eleve != null) {
            absences = obtenirEleveAbsences(eleve);
            if (absences != null) {
                Comparator<AbsenceEntity> comparator = (a1, a2) -> a1.getJour().compareTo(a2.getJour());
                Collections.sort(absences, comparator);
            }
        }
        return absences;
    }
}
