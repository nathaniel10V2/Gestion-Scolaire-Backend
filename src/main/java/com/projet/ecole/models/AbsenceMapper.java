package com.projet.ecole.models;

import java.util.ArrayList;
import java.util.List;

import com.projet.ecole.entities.AbsenceEntity;

public class AbsenceMapper {

    public static AbsenceModel transformerAbsence(AbsenceEntity absence) {
        AbsenceModel absenceModel = new AbsenceModel();
        absenceModel.setId(absence.getId());
        absenceModel.setDuree(absence.getDuree());
        absenceModel.setJour(absence.getJour());
        absenceModel.setJustifie(absence.getJustifie());

        return absenceModel;
    }

    public static AbsenceEntity transformerAbsenceModel(AbsenceModel absenceModel) {
        AbsenceEntity absence = new AbsenceEntity();
        absence.setId(absenceModel.getId());
        absence.setDuree(absenceModel.getDuree());
        absence.setJour(absenceModel.getJour());
        absence.setJustifie(absenceModel.getJustifie());

        return absence;
    }    

    public static List<AbsenceModel> transformerAbsences(List<AbsenceEntity> absences) {
        List<AbsenceModel> absenceModels = new ArrayList<>();
        for (AbsenceEntity absence : absences) {
            AbsenceModel absenceModel = transformerAbsence(absence);
            absenceModels.add(absenceModel);
        }

        return absenceModels;
    }    
}
