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
@Table(name = "cours")
public class CoursEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "PERIODE", length = 20)
    private String periode;

    @Column(name = "JOUR", length = 10, nullable = false)
    private String jour;

    @ManyToOne
    @JoinColumn(name = "MATIERE_ID", referencedColumnName = "ID")
    private MatiereEntity matiere;

    @ManyToOne
    @JoinColumn(name = "CLASSE_ID", referencedColumnName = "ID")
    private ClasseEntity classe;

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

    public MatiereEntity getMatiere() {
        return matiere;
    }

    public void setMatiere(MatiereEntity matiere) {
        this.matiere = matiere;
    }

    public ClasseEntity getClasse() {
        return classe;
    }

    public void setClasse(ClasseEntity classe) {
        this.classe = classe;
    }
}
