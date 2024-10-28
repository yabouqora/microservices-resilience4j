package com.example.microserviceadresse;

import com.example.microserviceadresse.dao.AdresseRepository;
import com.example.microserviceadresse.model.Adresse;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MicroServiceAdresseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceAdresseApplication.class, args);
	}
    @Bean
	ApplicationRunner start(AdresseRepository adresseRepository){
		return args -> {
			adresseRepository.save(new Adresse("rue woroud","20000","Casablanca",1L));
			adresseRepository.save(new Adresse("rue wahda","10000","Rabat",1L));
			adresseRepository.save(new Adresse("rue nassim","30000","Marrakech",2L));
			adresseRepository.save(new Adresse("rue ibno mandour","20000","Casablanca",3L));
		};
	}
}
