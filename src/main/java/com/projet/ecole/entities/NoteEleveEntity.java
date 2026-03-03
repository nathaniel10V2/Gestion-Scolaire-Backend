package com.projet.ecole.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notes_eleves")
public class NoteEleveEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "VALEUR", nullable = false)
    private Integer valeur;

    @ManyToOne
    @JoinColumn(name = "MATIERE_ID", referencedColumnName = "ID", nullable = false)
    private MatiereEntity matiere;

    @ManyToOne
    @JoinColumn(name = "ELEVE_ID", referencedColumnName = "ID")
    private EleveEntity eleve;

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

    public MatiereEntity getMatiere() {
        return matiere;
    }

    public void setMatiere(MatiereEntity matiere) {
        this.matiere = matiere;
    }

    public EleveEntity getEleve() {
        return eleve;
    }

    public void setEleve(EleveEntity eleve) {
        this.eleve = eleve;
    }
}
