package com.example.microservicepersonne;

import com.example.microservicepersonne.dao.PersonneRepository;
import com.example.microservicepersonne.model.Personne;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServicePersonneApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicePersonneApplication.class, args);
    }
     @Bean
    ApplicationRunner start(PersonneRepository personneRepository){
        return args -> {
          personneRepository.save(new Personne("abouqora","youness"));
          personneRepository.save(new Personne("El","Ali"));
          personneRepository.save(new Personne("Arij","Najat"));
        };
     }
}
