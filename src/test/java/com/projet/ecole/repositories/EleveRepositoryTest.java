package com.projet.ecole.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.projet.ecole.entities.EleveEntity;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class EleveRepositoryTest {
    
    @Autowired
    private EleveRepository eleveRepository;

    @Test
    void testFindByNom() {
        EleveEntity eleve = new EleveEntity();
        eleve.setId(1);
        eleve.setNom("Dupont");
        eleve.setPrenom("Bob");
        eleve.setAdresse("10 Rue des Champs");

        eleveRepository.save(eleve);
        var resultat = eleveRepository.findByNom("Dupont");
        Assertions.assertFalse(resultat == null, "Cet élève n'existe pas");
    }
}
