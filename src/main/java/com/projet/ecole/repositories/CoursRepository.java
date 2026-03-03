package com.projet.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.entities.CoursEntity;  
import java.util.List;


@Repository
public interface CoursRepository extends JpaRepository<CoursEntity, Integer> {

    @Query("SELECT c FROM CoursEntity c JOIN FETCH c.matiere WHERE c.classe = :classe")
    List<CoursEntity> findByClasse(@Param("classe") ClasseEntity classe);
}
