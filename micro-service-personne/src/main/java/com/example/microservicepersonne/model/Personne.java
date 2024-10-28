package com.example.microservicepersonne.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Personne {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String nom_personne;
    @NonNull
    private String prenom_personne;
}
