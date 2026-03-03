package com.projet.ecole.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "professeurs")
public class ProfesseurEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOM", length = 30, nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "MATIERE_ID", referencedColumnName = "ID", nullable = false)
    private MatiereEntity matiere;

    @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.MERGE)
    @JoinTable(name = "Professeur_Classes", joinColumns = { @JoinColumn(name = "PROFESSEUR_ID", nullable = false)},
    inverseJoinColumns = {@JoinColumn(name = "CLASSE_ID", nullable = false)} )
    private List<ClasseEntity> classes;

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

    public MatiereEntity getMatiere() {
        return matiere;
    }

    public void setMatiere(MatiereEntity matiere) {
        this.matiere = matiere;
    }

    public List<ClasseEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClasseEntity> classes) {
        this.classes = classes;
    }
}
