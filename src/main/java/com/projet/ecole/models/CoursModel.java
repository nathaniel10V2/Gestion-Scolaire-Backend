package com.projet.ecole.models;

public class CoursModel {

    private Integer id;
    private String periode;
    private String jour;
    private MatiereModel matiere;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPeriode() {
        return periode;
    }
    public void setPeriode(String periode) {
        this.periode = periode;
    }
    public String getJour() {
        return jour;
    }
    public void setJour(String jour) {
        this.jour = jour;
    }
    public MatiereModel getMatiere() {
        return matiere;
    }
    public void setMatiere(MatiereModel matiere) {
        this.matiere = matiere;
    }
}
