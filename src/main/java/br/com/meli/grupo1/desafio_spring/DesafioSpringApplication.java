package br.com.meli.grupo1.desafio_spring;

import br.com.meli.grupo1.desafio_spring.entities.Client;
import br.com.meli.grupo1.desafio_spring.repositories.RepoClient;
import br.com.meli.grupo1.desafio_spring.repositories.impl.JsonClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DesafioSpringApplication implements CommandLineRunner {
	@Autowired
	JsonClientRepository repoClient;


	public static void main(String[] args) {
		SpringApplication.run(DesafioSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/* Inicializando dados */
		List<Client> clients = new ArrayList<>(Arrays.asList(
				new Client(1L, "Gil Taveira Outeiro", "gilouteiro@email.com", "64000290", "Rua Arlindo Nogueira, 11, Centro, Teresina", "PI", "sdhfglwiejk123"),
				new Client(2L, "Juan Gago Fogaça", "gaguan@email.com", "64000290", "Rua da Imprensa, 345, Monte Castelo, Campo Grande", "MS", "iqwequequiiuq2"),
				new Client(3L, "Maksym Rosmaninho Rijo", "rijomask@email.com", "64000290", "Rua Perdidam 456, Centro, São Bernardo do Campo", "RJ", "qwieu22w"),
				new Client(4L, "Noa Marreiro Chainho", "noachainho@email.com", "64000290", "Rua dos Carijós, Centro, Belo Horizonte", "MG", "oksdofj23")
		));

		repoClient.setClients(clients);
	}
}
