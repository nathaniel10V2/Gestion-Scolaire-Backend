package com.projet.ecole.models;

import java.util.ArrayList;
import java.util.List;

import com.projet.ecole.entities.MatiereEntity;

public class MatiereMapper {

    public static MatiereModel transformerMatiere(MatiereEntity matiere) {
        MatiereModel matiereDto = new MatiereModel();
        matiereDto.setId(matiere.getId());
        matiereDto.setNom(matiere.getNom());
        return matiereDto;
    }

    public static MatiereEntity transformerMatiereModel(MatiereModel matiereModel) {
        MatiereEntity matiere = new MatiereEntity();
        matiere.setId(matiereModel.getId());
        matiere.setNom(matiereModel.getNom());
        return matiere;
    }

    public static List<MatiereModel> transformerMatieres(List<MatiereEntity> matieres) {
        List<MatiereModel> matiereDtos = new ArrayList<>();
        for (MatiereEntity matiere : matieres) {
            MatiereModel matiereDto = transformerMatiere(matiere);
            matiereDtos.add(matiereDto);
        }
        return matiereDtos;
    }    
}
