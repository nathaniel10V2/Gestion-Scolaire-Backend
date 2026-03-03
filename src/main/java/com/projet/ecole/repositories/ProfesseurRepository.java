package com.projet.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.ecole.entities.ProfesseurEntity;

import jakarta.transaction.Transactional;

import java.util.List;


public interface ProfesseurRepository extends JpaRepository<ProfesseurEntity, Integer> {

    @Query(value = "SELECT p FROM ProfesseurEntity p JOIN p.matiere m WHERE m.id = :matiereId")
    public abstract List<ProfesseurEntity> findByMatiere(Integer matiereId);

    @Query(value = "SELECT p FROM ProfesseurEntity p JOIN p.classes c WHERE c.id = :classeId")
    public abstract List<ProfesseurEntity> findByClasse(Integer classeId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Professeur_Classes WHERE professeur_id = :professeurId AND classe_id = :classeId", nativeQuery = true)
    void deleteClasse(@Param("professeurId") Integer professeurId, @Param("classeId") Integer classeId);
}
