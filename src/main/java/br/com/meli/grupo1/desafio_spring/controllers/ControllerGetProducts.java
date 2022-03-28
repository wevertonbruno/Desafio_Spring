package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.DTO.ArticlesDTO;
import br.com.meli.grupo1.desafio_spring.services.GetProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rogério e Jeferson
 * este controlador gerencia as rotas de requisições de produtos
 */
@RestController
public class ControllerGetProducts {
    @Autowired
    private GetProductsService service;

    /**
     * @author Rogério e Jeferson
     * este método mapea a rota de solicitação de produtos com suas diversas possibilidades de filtros e ordenações
     */
    @GetMapping(path = "/api/v1/articles")
    ResponseEntity<ArticlesDTO> getProducts(
            @RequestParam(required = false, name = "category") String category,
            @RequestParam(required = false, name = "freeShipping") Boolean freeShipping,
            @RequestParam(required = false, name = "product") String productName,
            @RequestParam(required = false, name = "brand") String brandName,
            @RequestParam(required = false, name = "order") Integer typeOrder) {
        ArticlesDTO articles = service.findProducts(category, freeShipping, productName, brandName,typeOrder);

        return ResponseEntity.ok(articles);
    }
}
