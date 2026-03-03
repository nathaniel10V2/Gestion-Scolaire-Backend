package com.projet.ecole.models;

import java.util.ArrayList;
import java.util.List;

public class ProfesseurModel {

    private Integer id;
    private String nom;
    private MatiereModel matiere;
    private List<ClasseModel> classes;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public MatiereModel getMatiere() {
        return matiere;
    }
    public void setMatiere(MatiereModel matiere) {
        this.matiere = matiere;
    }

    public List<ClasseModel> getClasses() {
        if (classes == null) {
           classes = new ArrayList<>(); 
        }
        return classes;
    }

    public void setClasses(List<ClasseModel> classes) {
        this.classes = classes;
    }
}
