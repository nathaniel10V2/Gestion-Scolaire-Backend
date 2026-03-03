package com.projet.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.EleveEntity;
import java.util.List;



@Repository
public interface EleveRepository extends JpaRepository<EleveEntity, Integer> {

    public abstract EleveEntity findByNom(String nom);

    public abstract List<EleveEntity> findByClasse(ClasseEntity classe);
} 
