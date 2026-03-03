package com.projet.ecole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ecole.entities.AbsenceEntity;
import com.projet.ecole.entities.EleveEntity;
import com.projet.ecole.entities.NoteEleveEntity;
import com.projet.ecole.models.AbsenceMapper;
import com.projet.ecole.models.AbsenceModel;
import com.projet.ecole.models.EleveMapper;
import com.projet.ecole.models.EleveModel;
import com.projet.ecole.models.NoteEleveMapper;
import com.projet.ecole.models.NoteEleveModel;
import com.projet.ecole.services.EleveService;
import com.projet.ecole.services.NoteEleveService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/eleve")
public class EleveController {
    
    @Autowired
    private EleveService eleveService;

    @Autowired
    private NoteEleveService noteEleveService;

    @GetMapping
    public List<EleveModel> obtenirEleves() {
        List<EleveEntity> eleves = eleveService.obtenirEleves();
        return EleveMapper.transformerEleves(eleves);
    }

    @GetMapping("/{id}")
    public EleveModel obtenirEleve(@PathVariable Integer id) {
        EleveEntity eleve = eleveService.obtenirEleve(id);
        return EleveMapper.transformerEleve(eleve);
    }  
    
    @GetMapping("/{id}/absences")
    public List<AbsenceModel> obtenirAbsences(@PathVariable Integer id) {
        List<AbsenceEntity> absences = eleveService.obtenirAbsences(id);
        return AbsenceMapper.transformerAbsences(absences);
    }   
    
    @GetMapping("/{id}/notes")
    public List<NoteEleveModel> obtenirNotes(@PathVariable Integer id) {
        List<NoteEleveEntity> notes = noteEleveService.obtenirEleveNotes(id);
        return NoteEleveMapper.transformerPlusieursNoteEleve(notes);
    }      

    @PostMapping()
    public EleveModel creerEleve(@RequestBody EleveModel eleveModel) {
        return eleveService.creerEleve(eleveModel);
    }  
    
    @PostMapping("/{id}")
    public EleveModel modifierEleve(@PathVariable Integer id, @RequestBody EleveModel eleveModel) {
        return eleveService.modifiEleve(id, eleveModel);
    }     
}
