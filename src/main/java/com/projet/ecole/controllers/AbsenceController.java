package com.projet.ecole.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ecole.entities.AbsenceEntity;
import com.projet.ecole.models.AbsenceMapper;
import com.projet.ecole.models.AbsenceModel;
import com.projet.ecole.services.AbsenceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/absence")
public class AbsenceController {

    private static final Logger log = LoggerFactory.getLogger(AbsenceController.class);

    @Autowired
    private AbsenceService absenceService;

    @PostMapping
    public AbsenceModel creerAbsence(@RequestBody AbsenceModel absenceModel, @RequestParam Integer eleveId) {
        log.info("absence = ");
        absenceService.creerAbsence(absenceModel, eleveId);
        return absenceModel;
    }

    @PostMapping("/trier")
    public List<AbsenceModel> trierAbsences(@RequestParam Integer eleveId) {
        List<AbsenceEntity> absences = absenceService.trierAbsences(eleveId);
        return AbsenceMapper.transformerAbsences(absences);
    }    
}
