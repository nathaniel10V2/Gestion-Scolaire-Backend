package com.projet.ecole.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.ProfesseurEntity;
import com.projet.ecole.models.ClasseMapper;
import com.projet.ecole.models.ProfesseurMapper;
import com.projet.ecole.models.ProfesseurModel;
import com.projet.ecole.repositories.ProfesseurRepository;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository; 
    
    public ProfesseurModel creerProfesseur(ProfesseurModel professeurModel) {
        ProfesseurEntity professeur = ProfesseurMapper.transformerProfesseurModel(professeurModel);
        professeurRepository.save(professeur);
        professeurModel.setId(professeur.getId());
        return professeurModel;
    } 

    public List<ProfesseurEntity> obtenirProfesseurs() {
        return professeurRepository.findAll();
    }

    public ProfesseurEntity obtenirProfesseur(Integer id) {
        return professeurRepository.findById(id).get();
    }    

    public List<ProfesseurEntity> obtenirClasseProfesseurs(Integer classeId) {
        return professeurRepository.findByClasse(classeId);
    }

    public List<ProfesseurEntity> obtenirMatiereProfesseurs(Integer matiereId) {
        return professeurRepository.findByMatiere(matiereId);
    }
    
    public ProfesseurModel modifierProfesseur(Integer id, ProfesseurModel professeurModel) {
        ProfesseurEntity professeur = professeurRepository.findById(id).get();

        if (professeur != null) {
            if (!professeurModel.getNom().isEmpty()) {
                professeur.setNom(professeurModel.getNom());
            }
            if (professeurModel.getClasses() != null) {
                List<ClasseEntity> classes = ClasseMapper.transformerClassesModel(professeurModel.getClasses());
                for (ClasseEntity classe : classes) {
                    if (!professeur.getClasses().contains(classe)) {
                        professeur.getClasses().add(classe);
                    }
                }
            }
            professeurRepository.save(professeur);
        }
        return ProfesseurMapper.transformerProfesseur(professeur);
    }

    public void retirerClasse(Integer id, Integer classeId) {
        professeurRepository.deleteClasse(id, classeId);
    }
}
