package com.projet.ecole.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class ClasseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOM", length = 30, nullable = false)
    private String nom;

    @ManyToMany(mappedBy = "classes")
    @JsonIgnore
    private List<ProfesseurEntity> professeurs;

    @OneToMany(mappedBy = "classe")
    private List<EleveEntity> eleves;

    @OneToMany(mappedBy = "classe")
    private List<CoursEntity> cours;

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

    public List<ProfesseurEntity> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<ProfesseurEntity> professeurs) {
        this.professeurs = professeurs;
    }

    public List<EleveEntity> getEleves() {
        return eleves;
    }

    public void setEleves(List<EleveEntity> eleves) {
        this.eleves = eleves;
    }

    public List<CoursEntity> getCours() {
        return cours;
    }

    public void setCours(List<CoursEntity> cours) {
        this.cours = cours;
    }    
}
