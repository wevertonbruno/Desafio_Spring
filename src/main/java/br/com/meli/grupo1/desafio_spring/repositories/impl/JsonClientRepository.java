package br.com.meli.grupo1.desafio_spring.repositories.impl;


import br.com.meli.grupo1.desafio_spring.entities.Client;
import br.com.meli.grupo1.desafio_spring.repositories.RepoClient;
import br.com.meli.grupo1.desafio_spring.utils.JsonUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JsonClientRepository implements RepoClient {

    private List<Client> clients;

    public JsonClientRepository() throws IOException {
        clients = JsonUtil.readAsList("file:src/main/resources/data/clients.json", Client[].class);
    }

    @Override
    public Client createClient(Client client) {
        Long id = clients.size() + 1L;
        client.setClienteId(id);
        clients.add(client);

        try {
            JsonUtil.saveAsFile("file:src/main/resources/data/clients.json", clients);
            return client;
        }catch (IOException e){
            return null;
        }
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        Optional<Client> isHaveEmail = clients.stream().filter(x -> x.getEmail().equals(email)).findFirst();
        return isHaveEmail;
    }

    @Override
    public List<Client> findAll() {
        return clients;
    }

    @Override
    public List<Client> search(String estado) {
        return clients.stream().filter(client -> client.getEstado().equalsIgnoreCase(estado)).collect(Collectors.toList());
    }

    public void setClients(List<Client> clients){
        this.clients = clients;
        persist(clients);
    }

    private void persist(List<Client> clients){
        try {
            JsonUtil.saveAsFile("file:src/main/resources/data/clients.json", clients);
        }catch (IOException e){
            System.out.println("Falha ao persistir dados");
        }
    }
}
