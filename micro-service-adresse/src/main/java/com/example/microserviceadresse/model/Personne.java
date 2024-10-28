package com.example.microserviceadresse.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Personne {
    private long id;
    @NonNull
    private String nom_personne;
    @NonNull
    private String prenom_personne;
}
