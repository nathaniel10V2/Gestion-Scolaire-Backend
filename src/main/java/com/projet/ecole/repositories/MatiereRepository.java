package com.projet.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.ecole.entities.MatiereEntity;
import java.util.List;
import com.projet.ecole.entities.ProfesseurEntity;


@Repository
public interface MatiereRepository extends JpaRepository<MatiereEntity, Integer> {

    @Query("SELECT m FROM MatiereEntity m WHERE m IN (SELECT p.matiere FROM ProfesseurEntity p WHERE p IN :professeurs)")
    public abstract List<MatiereEntity> findMatieresByProfesseurs(@Param("professeurs") List<ProfesseurEntity> professeurs);
}
