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


/*
* Controller da compra
* @author Weverton Bruno e Gabriel Essenio
* */
@RestController
@RequestMapping("api/v1")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    /*
    * Escuta uma requisicao POST no endpoint api/v1/purchase-request
    * que espera no body um objeto PurchaseRequestDTO
    * retorna status code 200 com a compra representada pelo ListOrderDTO em caso de sucesso
    * */
    @PostMapping("/purchase-request")
    public ResponseEntity<ListOrderDTO> purchaseOrder(@RequestBody PurchaseRequestDTO products){
        ListOrderDTO orderPurchase = purchaseService.purchaseOrder(products);
        return ResponseEntity.ok().body(orderPurchase);
    }
}
