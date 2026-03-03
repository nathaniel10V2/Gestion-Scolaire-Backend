package com.projet.ecole.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "eleves")
public class EleveEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOM", length = 30, nullable = false)
    private String nom;

    @Column(name = "PRENOM", length = 20, nullable = false)
    private String prenom;

    @Column(name = "ADRESSE", length = 30, nullable = false)
    private String adresse;

    @ManyToOne
    @JoinColumn(name = "CLASSE_ID", referencedColumnName = "ID", nullable = false)
    private ClasseEntity classe;

    @OneToMany(mappedBy = "eleve")
    private List<AbsenceEntity> absences;

    @OneToMany(mappedBy = "eleve")
    private List<NoteEleveEntity> notes;

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

    public ClasseEntity getClasse() {
        return classe;
    }

    public void setClasse(ClasseEntity classe) {
        this.classe = classe;
    }

    public List<AbsenceEntity> getAbsences() {
        return absences;
    }

    public void setAbsences(List<AbsenceEntity> absences) {
        this.absences = absences;
    }

    public List<NoteEleveEntity> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteEleveEntity> notes) {
        this.notes = notes;
    }    
}
