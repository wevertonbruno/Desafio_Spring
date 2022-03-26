package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.DTO.ClientDTO;
import br.com.meli.grupo1.desafio_spring.DTO.ClientResponseDTO;
import br.com.meli.grupo1.desafio_spring.services.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ControllerClient {

    @Autowired
    private ServiceClient serviceClient;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientDTO clientDTO, HttpServletRequest http) {
        ClientResponseDTO clientResponseDTO = serviceClient.createClient(clientDTO);
        return ResponseEntity.created(URI.create(http.getRequestURI())).body(clientResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getClients(){
        List<ClientResponseDTO> response = serviceClient.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ClientResponseDTO>> getClients(@RequestParam String estado){
        List<ClientResponseDTO> response = serviceClient.search(estado);
        return ResponseEntity.ok(response);
    }
}
