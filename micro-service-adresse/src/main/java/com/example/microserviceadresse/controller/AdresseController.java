package com.example.microserviceadresse.controller;

import com.example.microserviceadresse.dao.AdresseRepository;
import com.example.microserviceadresse.model.Adresse;
import com.example.microserviceadresse.restclient.PersonneRestClient;


import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class AdresseController {
     @Autowired
    private AdresseRepository adresseRepository;
     @Autowired
    private PersonneRestClient personneRestClient;


    public static final String ADRESSE_SERVICE="adresseService";
    @GetMapping("/adresses")
    @Bulkhead(name = ADRESSE_SERVICE)
    @TimeLimiter(name=ADRESSE_SERVICE)
//    @RateLimiter(name=ADRESSE_SERVICE)
//    @CircuitBreaker(name=ADRESSE_SERVICE, fallbackMethod ="getDefaultAdresses")
//    @Retry(name=ADRESSE_SERVICE)
    public List<Adresse> getAdresses(){
        var adresses= adresseRepository.findAll();
        for(Adresse a : adresses){
            a.setPersonne(personneRestClient.getPersonne(a.getIdPersonne()));
        }

        return adresses;
    }

    @GetMapping("/adresses/{id}")
    @Bulkhead(name = ADRESSE_SERVICE)
    @TimeLimiter(name=ADRESSE_SERVICE)
//    @RateLimiter(name=ADRESSE_SERVICE)
//    @CircuitBreaker(name=ADRESSE_SERVICE, fallbackMethod = "getDefaultAdress")
//    @Retry(name=ADRESSE_SERVICE)
    public Adresse getAdresse(@PathVariable long id){
        Adresse adresse= adresseRepository.findById(id).orElse(null);
       adresse.setPersonne(personneRestClient.getPersonne(adresse.getIdPersonne()));
        return adresse;
    }
    @PostMapping("/adresses")
    public Adresse addAdresse(@RequestBody Adresse adresse){
        return adresseRepository.save(adresse);
    }

    public List<Adresse> getDefaultAdresses(Exception e){
        return Stream.of(
                Adresse.builder()
                        .rue("rue inconnue")
                        .codePostal("code inconnue")
                        .ville("aucune ville")
                        .idPersonne(0L)
                        .personne(null)
                        .build()
        ).collect(Collectors.toList());
    }
    public Adresse getDefaultAdress(Exception e) {
        return Adresse.builder()
                .rue("rue inconnue")
                .codePostal("code inconnue")
                .ville("aucune ville")
                .idPersonne(0L)
                .personne(null)
                .build();
    }




}
