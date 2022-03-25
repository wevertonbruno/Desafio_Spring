package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.entities.Client;

import java.util.Optional;

// @author todo mundo
// interface do repositorio para cadasatro de cliente
public interface RepoClient {
    public Client createClient(Client client);

    public Optional<Client> findByEmail(String email);
}
