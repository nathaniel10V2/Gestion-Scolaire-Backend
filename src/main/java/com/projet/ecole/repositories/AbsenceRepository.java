package com.projet.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.ecole.entities.AbsenceEntity;
import com.projet.ecole.entities.EleveEntity;

import java.util.List;


@Repository
public interface AbsenceRepository extends JpaRepository<AbsenceEntity,Integer>{

    public abstract List<AbsenceEntity> findByEleve(EleveEntity eleve);
}
