package com.example.microserviceadresse.dao;

import com.example.microserviceadresse.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
}
