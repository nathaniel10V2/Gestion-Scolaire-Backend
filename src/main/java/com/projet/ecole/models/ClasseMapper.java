package com.projet.ecole.models;

import java.util.ArrayList;
import java.util.List;

import com.projet.ecole.entities.ClasseEntity;

public class ClasseMapper {

    public static ClasseModel transformerClasse(ClasseEntity classe) {
        ClasseModel classeModel = new ClasseModel();
        classeModel.setId(classe.getId());
        classeModel.setNom(classe.getNom());
        return classeModel;
    }

    public static ClasseEntity transformerClasseModel(ClasseModel classeModel) {
        ClasseEntity classe  = new ClasseEntity();
        if (classeModel != null) {
            classe.setId(classeModel.getId());
            classe.setNom(classeModel.getNom());
        }
        return classe;
    }

    public static List<ClasseModel> transformerClasses(List<ClasseEntity> classes) {
        List<ClasseModel> classeModels = new ArrayList<>();
        for (ClasseEntity classe: classes) {
            ClasseModel classeModel = transformerClasse(classe);
            classeModels.add(classeModel);
        }
        return classeModels;
    }

    public static List<ClasseEntity> transformerClassesModel(List<ClasseModel> classeModels) {
        List<ClasseEntity> classes = new ArrayList<>();
        for (ClasseModel classeModel: classeModels) {
            ClasseEntity classe = transformerClasseModel(classeModel);
            classes.add(classe);
        }
        return classes;
    }    
}
