package com.projet.ecole.models;

import java.util.Date;

public class AbsenceModel {

    private Integer id;
    private String duree;
    private Boolean justifie;
    private Date jour;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDuree() {
        return duree;
    }
    public void setDuree(String duree) {
        this.duree = duree;
    }
    public Boolean getJustifie() {
        return justifie;
    }
    public void setJustifie(Boolean justifie) {
        this.justifie = justifie;
    }
    public Date getJour() {
        return jour;
    }
    public void setJour(Date jour) {
        this.jour = jour;
    }
}
