package com.projet.ecole.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "absences")
public class AbsenceEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "DUREE", length = 30)
    private String duree;

    @Column(name = "JUSTIFIE", nullable = false)
    private Boolean justifie;

    @Column(name = "JOUR", nullable = false)
    private Date jour;

    @ManyToOne
    @JoinColumn(name = "ELEVE_ID", referencedColumnName = "ID")
    private EleveEntity eleve;

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
    
    public EleveEntity getEleve() {
        return eleve;
    }

    public void setEleve(EleveEntity eleve) {
        this.eleve = eleve;
    }    
}
