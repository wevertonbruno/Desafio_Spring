package br.com.meli.grupo1.desafio_spring.controllers;

import br.com.meli.grupo1.desafio_spring.DTO.purchases.ListOrderDTO;
import br.com.meli.grupo1.desafio_spring.DTO.purchases.PurchaseRequestDTO;
import br.com.meli.grupo1.desafio_spring.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchase-request")
    public ResponseEntity<ListOrderDTO> purchaseOrder(@RequestBody PurchaseRequestDTO products){
        ListOrderDTO orderPurchase = purchaseService.purchaseOrder(products);
        return ResponseEntity.ok().body(orderPurchase);
    }
}
