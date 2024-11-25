package com.example.superheroes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.superheroes.entities.HeroeEntity;
import com.example.superheroes.services.HeroeService;

@RestController
@RequestMapping("/api/v1/heroes")
public class HeroeController {
    @Autowired 
    HeroeService heroeService;
    
    //GET de todos los heroes
    @GetMapping
    public ResponseEntity<List<HeroeEntity>> getHeroes(){
        return ResponseEntity.ok(heroeService.getAllHeroes());
    }

    //GET de un heroe
    @GetMapping("/{id}")
    public ResponseEntity<HeroeEntity> getHeroeById(@PathVariable Long id){
        return ResponseEntity.ok(heroeService.getHeroeById(id));
    }

    //POST de un heroe
    @PostMapping
    public ResponseEntity<HeroeEntity> createHeroe(@RequestBody HeroeEntity heroeEntity){
        return ResponseEntity.ok(heroeService.createHeroe(heroeEntity));
    }

    //PUT de un heroe
    @PutMapping("/{id}")
    public ResponseEntity<HeroeEntity> updateHeroe(@RequestBody HeroeEntity heroeEntity, @PathVariable Long id){
        heroeEntity.setId(id);
        return ResponseEntity.ok(heroeService.updateHeroe(heroeEntity));
    }
    //DELETE de un heroe
    @DeleteMapping("/{id}")
    public ResponseEntity<HeroeEntity> deleteHeroe(@PathVariable Long id){
        heroeService.deleteHeroe(id);
        return ResponseEntity.noContent().build();
    }
}
