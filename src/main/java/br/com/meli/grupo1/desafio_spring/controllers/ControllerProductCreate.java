package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.DTO.CreateRequestDTO;
import br.com.meli.grupo1.desafio_spring.DTO.ProductCreateResponseDTO;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.repositories.RepoCreateProduct;
import br.com.meli.grupo1.desafio_spring.services.ServiceProductCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ControllerProductCreate {

    @Autowired
    private ServiceProductCreate serviceProductCreate;

    @PostMapping("/insert-articles-request")
    public ResponseEntity <ProductCreateResponseDTO> create (@RequestBody CreateRequestDTO articles, HttpServletRequest httpServletRequest){
        return ResponseEntity.created(URI.create(httpServletRequest.getRequestURI())).body(serviceProductCreate.create(articles));

    }

}
