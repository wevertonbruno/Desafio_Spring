package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.DTO.PurchaseRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchase-request")
    public ResponseEntity<Order> purchaseOrder(@RequestBody PurchaseRequestDTO products){
        Order orderPurchase = purchaseService.purchaseOrder(products);
        ResponseEntity.ok().body(orderPurchase);
    }
}
