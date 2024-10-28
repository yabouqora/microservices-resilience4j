package com.example.microserviceadresse.restclient;

import com.example.microserviceadresse.model.Personne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("PERSONNE-SERVICE")
public interface PersonneRestClient {
    @GetMapping("/api/personnes")
    public List<Personne> getPersonnes();
    @GetMapping("/api/personnes/{id}")
    public Personne getPersonne(@PathVariable long id);
}
