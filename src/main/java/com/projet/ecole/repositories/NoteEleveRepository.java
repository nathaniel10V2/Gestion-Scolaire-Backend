package com.projet.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.ecole.entities.EleveEntity;
import com.projet.ecole.entities.NoteEleveEntity;
import java.util.List;


@Repository
public interface NoteEleveRepository extends JpaRepository<NoteEleveEntity,Integer> {

    public abstract List<NoteEleveEntity> findByEleve(EleveEntity eleve);
}
