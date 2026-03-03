package com.projet.ecole.models;

import java.util.ArrayList;
import java.util.List;

import com.projet.ecole.entities.CoursEntity;

public class CoursMapper {

    public static CoursModel transformerUnCours(CoursEntity cours) {
        CoursModel coursModel = new CoursModel();
        coursModel.setId(cours.getId());
        coursModel.setJour(cours.getJour());
        coursModel.setPeriode(cours.getPeriode());
        coursModel.setMatiere(MatiereMapper.transformerMatiere(cours.getMatiere()));
        return coursModel;
    }

    public static CoursEntity transformerUnCoursModel(CoursModel coursModel) {
        CoursEntity cours = new CoursEntity();
        cours.setId(coursModel.getId());
        cours.setJour(coursModel.getJour());
        cours.setPeriode(coursModel.getPeriode());
        return cours;
    }    

    public static List<CoursModel> transformerPlusieursCours(List<CoursEntity> coursList) {
        List<CoursModel> coursModels = new ArrayList<>();
        for (CoursEntity cours : coursList) {
            CoursModel coursModel = transformerUnCours(cours);
            coursModels.add(coursModel);
        }
        return coursModels;
    }
}
