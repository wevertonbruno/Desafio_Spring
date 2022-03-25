package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.DTO.ClientDTO;
import br.com.meli.grupo1.desafio_spring.DTO.ClientResponseDTO;
import br.com.meli.grupo1.desafio_spring.services.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
public class ControllerClient {

    @Autowired
    private ServiceClient serviceClient;

    @PostMapping("/api/v1/client")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientDTO clientDTO, HttpServletRequest http) {
        ClientResponseDTO clientResponseDTO = serviceClient.createClient(clientDTO);
        return ResponseEntity.created(URI.create(http.getRequestURI())).body(clientResponseDTO);
    }
}
