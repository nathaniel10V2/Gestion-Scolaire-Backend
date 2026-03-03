package com.projet.ecole.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "matieres")
public class MatiereEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "matiere")
    private List<ProfesseurEntity> professeurs;

    @OneToMany(mappedBy = "matiere")
    private List<CoursEntity> cours;

    @OneToMany(mappedBy = "matiere")
    private List<NoteEleveEntity> notesEleve;

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

    public List<CoursEntity>  getCours() {
        return cours;
    }

    public void setCours(List<CoursEntity> cours) {
        this.cours = cours;
    }

    public List<NoteEleveEntity> getNoteEleve() {
        return notesEleve;
    }

    public void setNoteEleve(List<NoteEleveEntity> noteEleve) {
        this.notesEleve = noteEleve;
    }        
}
