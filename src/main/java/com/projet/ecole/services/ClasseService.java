package com.projet.ecole.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ecole.entities.ClasseEntity;
import com.projet.ecole.repositories.ClasseRepository;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public ClasseEntity creerClasse(ClasseEntity classe) {
       return classeRepository.save(classe);
    }

    public ClasseEntity obtenirClasse(Integer id) {
        return classeRepository.findById(id).orElseThrow(() -> new RuntimeException("Classe introuvable"));
    }

    public List<ClasseEntity> obtenirClasses() {
        return classeRepository.findAll();
    }

    public List<ClasseEntity> obtenirProfesseurClasses(Integer professeurId) {
        return classeRepository.findByProfesseur(professeurId);
    }  
    
    public void retirerProfesseur(Integer id, Integer professeurId) {
        classeRepository.deleteProfesseur(id, professeurId);
    }
}
