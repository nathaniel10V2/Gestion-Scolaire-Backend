package com.projet.ecole.models;

public class NoteEleveModel {

    private Integer id;
    private Integer valeur;
    private MatiereModel matiere;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getValeur() {
        return valeur;
    }
    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }
    public MatiereModel getMatiereModel() {
        return matiere;
    }
    public void setMatiereModel(MatiereModel matiereModel) {
        this.matiere = matiereModel;
    }
}
