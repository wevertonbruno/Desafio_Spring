package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.DTO.ArticlesDTO;
import br.com.meli.grupo1.desafio_spring.repositories.GetAllArticles;
import br.com.meli.grupo1.desafio_spring.services.GetArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerGetArticles {
    @Autowired
    private GetArticleService service;

    @GetMapping(path = "/api/v1/articles")
    ResponseEntity<ArticlesDTO> getArticles(
            @RequestParam(required = false, name = "category") String category,
            @RequestParam(required = false, name = "freeShipping") Boolean freeShipping,
            @RequestParam(required = false, name = "product") String productName,
            @RequestParam(required = false, name = "brand") String brandName,
            @RequestParam(required = false, name = "order") Integer typeOrder) {
        ArticlesDTO articles = service.findArticles(category, freeShipping, productName, brandName,typeOrder);

        return ResponseEntity.ok(articles);
    }
}
