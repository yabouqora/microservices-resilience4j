package com.example.microservicepersonne.dao;

import com.example.microservicepersonne.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
