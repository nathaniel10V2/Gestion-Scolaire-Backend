package com.projet.ecole.models;

import java.util.ArrayList;
import java.util.List;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.EleveEntity;

public class EleveMapper {

    public static EleveModel transformerEleve(EleveEntity eleve) {
        EleveModel eleveModel = new EleveModel();
        eleveModel.setId(eleve.getId());
        eleveModel.setNom(eleve.getNom());
        eleveModel.setPrenom(eleve.getPrenom());
        eleveModel.setAdresse(eleve.getAdresse());
        ClasseModel classeModel = ClasseMapper.transformerClasse(eleve.getClasse());
        eleveModel.setClasseModel(classeModel);
        return eleveModel;
    }

    public static EleveEntity transformerEleveModel(EleveModel eleveModel) {
        EleveEntity eleve = new EleveEntity();
        eleve.setId(eleveModel.getId());
        eleve.setNom(eleveModel.getNom());
        eleve.setPrenom(eleveModel.getPrenom());
        eleve.setAdresse(eleveModel.getAdresse());
        ClasseEntity classe =  ClasseMapper.transformerClasseModel(eleveModel.getClasseModel());
        eleve.setClasse(classe);    
        return eleve;
    }    

    public static List<EleveModel> transformerEleves(List<EleveEntity> eleves) {
        List<EleveModel> eleveModels = new ArrayList<>();
        for (EleveEntity eleve : eleves) {
            EleveModel eleveModel = transformerEleve(eleve);
            eleveModels.add(eleveModel);
        }
        return eleveModels;
    }    
}
