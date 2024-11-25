package com.example.superheroes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.superheroes.entities.HeroeEntity;
import com.example.superheroes.repositories.HeroeRepository;

@Service
public class HeroeService {
    @Autowired
    HeroeRepository heroeRepository;

    //GET de todos los heroes
    public List<HeroeEntity> getAllHeroes(){
        return heroeRepository.findAll();
    }

    //GET de un heroe
    public HeroeEntity getHeroeById(Long id){
        return heroeRepository.findById(id).orElse(null);
    }

    //POST de un heroe
    public HeroeEntity createHeroe(HeroeEntity heroeEntity){
        return heroeRepository.save(heroeEntity);
    }

    //PUT de un heroe
    public HeroeEntity updateHeroe(HeroeEntity heroeEntity){
        return heroeRepository.save(heroeEntity);
    }
    //DELETE de un heroe
    public void deleteHeroe(Long id){
        heroeRepository.deleteById(id);
    }
}
