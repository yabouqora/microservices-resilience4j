package com.example.microservicepersonne.controller;

import com.example.microservicepersonne.dao.PersonneRepository;
import com.example.microservicepersonne.model.Personne;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PersonneController {

    private PersonneRepository personneRepository;

    @GetMapping("/personnes")
    public List<Personne> getPersonnes(){
        return personneRepository.findAll();
    }
    @GetMapping("/personnes/{id}")
    public Personne getPersonne(@PathVariable long id){
        return personneRepository.findById(id).orElse(null);
    }
    @PostMapping("/personnes")
    public Personne addPersonne(@RequestBody Personne personne){
        return personneRepository.save(personne);
    }
}
