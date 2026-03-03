package com.projet.ecole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ecole.entities.NoteEleveEntity;
import com.projet.ecole.models.NoteEleveMapper;
import com.projet.ecole.models.NoteEleveModel;
import com.projet.ecole.services.NoteEleveService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/note")
public class NoteEleveController {

    @Autowired
    private NoteEleveService noteEleveService;
    
    @PostMapping
    public NoteEleveModel creerNote(@RequestParam Integer eleve, @RequestParam Integer valeur, @RequestParam String matiere) {
        NoteEleveModel noteEleveModel = noteEleveService.creerNote(eleve, valeur, matiere);
        return noteEleveModel;
    }

    @PostMapping("/trier")
    public List<NoteEleveModel> trierNotes(@RequestParam Integer eleveId) {
        List<NoteEleveEntity> notes = noteEleveService.trierNote(eleveId);
        return NoteEleveMapper.transformerPlusieursNoteEleve(notes);
    }    
}
