package com.projet.ecole.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.MatiereEntity;
import com.projet.ecole.entities.ProfesseurEntity;
import com.projet.ecole.repositories.MatiereRepository;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    @Autowired
    private ClasseService classeService;

    @Autowired
    private ProfesseurService professeurService;    

    public MatiereEntity creerMatiere(MatiereEntity matiere) {
        if (matiere.getNom() == null || matiere.getNom().isEmpty()) {
            throw new IllegalArgumentException("Le nom de la matiere est requis");
        }

        return matiereRepository.save(matiere);
    }
    
    public List<MatiereEntity> obtenirMatieres() {
        return matiereRepository.findAll();
    }

    public MatiereEntity obtenirMatiere(Integer id) {
        return matiereRepository.findById(id).get();
    }
    
    public List<MatiereEntity> obtenirProfesseursMatieres(List<ProfesseurEntity> professeurs) {
        return matiereRepository.findMatieresByProfesseurs(professeurs);
    }

    public List<MatiereEntity> obtenirMatieres(Integer claaseId) {
        ClasseEntity classe = classeService.obtenirClasse(claaseId);
        List<ProfesseurEntity> professeurs = professeurService.obtenirClasseProfesseurs(classe.getId());
        List<MatiereEntity> matieres = obtenirProfesseursMatieres(professeurs);
        return matieres;
    }    
}
