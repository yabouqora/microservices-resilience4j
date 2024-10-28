package com.example.microserviceadresse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Builder
public class Adresse {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String rue;
    @NonNull
    private String codePostal;
    @NonNull
    private String ville;
    @NonNull
    private long idPersonne;
    @Transient
    private Personne personne;
}
