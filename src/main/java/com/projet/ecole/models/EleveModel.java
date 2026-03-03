package com.projet.ecole.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EleveModel {

    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    @JsonProperty("classe")
    private ClasseModel classe;
    
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
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public ClasseModel getClasseModel() {
        return classe;
    }
    public void setClasseModel(ClasseModel classeModel) {
        this.classe = classeModel;
    }    
}
