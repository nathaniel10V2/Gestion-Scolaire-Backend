package com.projet.ecole.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecole.entities.EleveEntity;
import com.projet.ecole.entities.MatiereEntity;
import com.projet.ecole.entities.NoteEleveEntity;
import com.projet.ecole.models.NoteEleveMapper;
import com.projet.ecole.models.NoteEleveModel;
import com.projet.ecole.repositories.NoteEleveRepository;

@Service
public class NoteEleveService {

    @Autowired
    NoteEleveRepository noteEleveRepository;

    @Autowired
    private EleveService eleveService;    

    @Autowired
    private MatiereService matiereService;    

    public NoteEleveModel creerNote(Integer eleveId, Integer valeur, String matiereNom) {
        NoteEleveModel noteEleveModel = new NoteEleveModel();
        NoteEleveEntity noteEleve = new NoteEleveEntity();
        MatiereEntity matiere = selectionnerMatiere(eleveId, matiereNom);
        if (matiere != null) {
            noteEleve.setMatiere(matiere);
            noteEleve.setValeur(valeur);
            EleveEntity eleve = eleveService.obtenirEleve(eleveId);
            noteEleve.setEleve(eleve);
            noteEleveRepository.save(noteEleve);
            attribuerNote(eleveId);
            noteEleveModel = NoteEleveMapper.transformerNoteEleve(noteEleve);
        }
        return noteEleveModel;
    }

    public NoteEleveEntity obtenirNote() {
        return noteEleveRepository.findAll().getLast();
    }   

    public List<NoteEleveEntity> obtenirEleveNotes(Integer eleveId) {
        EleveEntity eleve = eleveService.obtenirEleve(eleveId);
        return noteEleveRepository.findByEleve(eleve);
    }

    private void attribuerNote(Integer eleveId) {
        EleveEntity eleve = eleveService.obtenirEleve(eleveId);
        NoteEleveEntity noteEleve = obtenirNote();
        noteEleve.setEleve(eleve);
        noteEleveRepository.save(noteEleve);
    }

    private MatiereEntity selectionnerMatiere(Integer eleveId, String matiereNom) {
        EleveEntity eleve = eleveService.obtenirEleve(eleveId);
        List<MatiereEntity> matieres = matiereService.obtenirMatieres(eleve.getClasse().getId());
        MatiereEntity matiere = matieres.stream().filter(m -> m.getNom().equals(matiereNom)).findFirst().get();
        return matiere;
    } 

    public List<NoteEleveEntity> trierNote(Integer eleveId) {
        List<NoteEleveEntity> notes = obtenirEleveNotes(eleveId);;
        if (notes != null) {
            Comparator<NoteEleveEntity> comparator = Comparator.comparing(NoteEleveEntity::getMatiere, Comparator.comparing(MatiereEntity::getNom, String.CASE_INSENSITIVE_ORDER));
            Collections.sort(notes, comparator);
        }
        return notes;
    }
}
