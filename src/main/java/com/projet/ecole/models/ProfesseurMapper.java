package com.projet.ecole.models;

import java.util.ArrayList;
import java.util.List;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.MatiereEntity;
import com.projet.ecole.entities.ProfesseurEntity;

public class ProfesseurMapper {

    public static ProfesseurModel transformerProfesseur(ProfesseurEntity professeur) {
        ProfesseurModel professeurModel = new ProfesseurModel();
        professeurModel.setId(professeur.getId());
        professeurModel.setNom(professeur.getNom());
        MatiereModel matiereModel = MatiereMapper.transformerMatiere(professeur.getMatiere());
        professeurModel.setMatiere(matiereModel);
        List<ClasseModel> classesModel = ClasseMapper.transformerClasses(professeur.getClasses());
        professeurModel.setClasses(classesModel);
        return professeurModel;
    }

    public static ProfesseurEntity transformerProfesseurModel(ProfesseurModel professeurModel) {
        ProfesseurEntity professeur = new ProfesseurEntity();
        professeur.setId(professeurModel.getId());
        professeur.setNom(professeurModel.getNom());
        MatiereEntity matiere = MatiereMapper.transformerMatiereModel(professeurModel.getMatiere());
        professeur.setMatiere(matiere);
        List<ClasseEntity> classes = ClasseMapper.transformerClassesModel(professeurModel.getClasses());
        professeur.setClasses(classes);
        return professeur;
    }

    public static List<ProfesseurModel> transformerProfesseurs(List<ProfesseurEntity> professeurs) {
        List<ProfesseurModel> professeurModels = new ArrayList<>();
        for (ProfesseurEntity prof : professeurs) {
            ProfesseurModel professeurModel = transformerProfesseur(prof);
            professeurModels.add(professeurModel);
        }
        return professeurModels;
    }    
}
