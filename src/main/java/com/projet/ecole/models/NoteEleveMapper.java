package com.projet.ecole.models;

import java.util.ArrayList;
import java.util.List;

import com.projet.ecole.entities.NoteEleveEntity;

public class NoteEleveMapper {

    public static NoteEleveModel transformerNoteEleve(NoteEleveEntity noteEleve) {
        NoteEleveModel noteEleveModel = new NoteEleveModel();
        noteEleveModel.setId(noteEleve.getId());
        noteEleveModel.setValeur(noteEleve.getValeur());
        MatiereModel matiereModel = MatiereMapper.transformerMatiere(noteEleve.getMatiere());
        noteEleveModel.setMatiereModel(matiereModel);

        return noteEleveModel;
    }
 
    public static List<NoteEleveModel> transformerPlusieursNoteEleve(List<NoteEleveEntity> notes) {
        List<NoteEleveModel> noteEleveModels = new ArrayList<>();
        for (NoteEleveEntity noteEleve : notes) {
            NoteEleveModel noteEleveModel = NoteEleveMapper.transformerNoteEleve(noteEleve);
            noteEleveModels.add(noteEleveModel);
        }

        return noteEleveModels;
    }    
}
