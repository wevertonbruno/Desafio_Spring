package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.ClientDTO;
import br.com.meli.grupo1.desafio_spring.DTO.ClientResponseDTO;
import br.com.meli.grupo1.desafio_spring.entities.Client;
import br.com.meli.grupo1.desafio_spring.exceptions.EmailInUseException;
import br.com.meli.grupo1.desafio_spring.repositories.RepoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// @author feito por todos
// Service para o cliente, responsavel pela regra de negocio
@Service
public class ServiceClient {

    // faz a conexao com RepoClient
    @Autowired
    private RepoClient repoClient;

    public ClientResponseDTO createClient(ClientDTO clientDTO) {
        Optional<Client> clientByEmail = repoClient.findByEmail(clientDTO.getEmail());

        if (clientByEmail.isPresent()) {
            throw new EmailInUseException("E-mail já cadastrado"); // TODO criar excecao personalizada
        }

        Client client = new Client(null, clientDTO.getNome(), clientDTO.getEmail(), clientDTO.getCep(), clientDTO.getEndereco(), clientDTO.getEstado(), clientDTO.getSenha());

        client = repoClient.createClient(client);

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(client.getClienteId(), client.getNome(), client.getEmail());

        return clientResponseDTO;
    }

    public List<ClientResponseDTO> findAll(){
        return repoClient.findAll().stream().map(client -> new ClientResponseDTO(
            client.getClienteId(),
            client.getNome(),
            client.getEmail()
        )).collect(Collectors.toList());
    }

    public List<ClientResponseDTO> search(String estado) {
        return repoClient.search(estado)
                .stream().map(client -> new ClientResponseDTO(
                    client.getClienteId(),
                    client.getNome(),
                    client.getEmail()
                )).collect(Collectors.toList());
    }
}
