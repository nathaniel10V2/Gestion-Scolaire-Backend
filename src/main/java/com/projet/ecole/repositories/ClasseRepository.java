package com.projet.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.ecole.entities.ClasseEntity;

import jakarta.transaction.Transactional;

import java.util.List;




@Repository
public interface ClasseRepository extends JpaRepository<ClasseEntity, Integer> {

    @Query(value = "SELECT c FROM ClasseEntity c JOIN c.professeurs p WHERE p.id = :professeurId")
    public abstract List<ClasseEntity> findByProfesseur(Integer professeurId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Professeur_Classes WHERE classe_id = :classeId AND professeur_id = :professeurId", nativeQuery = true)
    public void deleteProfesseur(@Param("classeId") Integer classeId, @Param("professeurId") Integer professeurId);    
}
