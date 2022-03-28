package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.DTO.cart.CartResponseDTO;
import br.com.meli.grupo1.desafio_spring.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<CartResponseDTO> cart(){
        return ResponseEntity.ok(cartService.cart());
    }
}
