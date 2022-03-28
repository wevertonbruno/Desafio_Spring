package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.DTO.purchases.PurchaseDTO;
import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.entities.Purchase;

import java.util.List;


/*
* Interface do Repositorio de Compras com os metodos auxiliares para realizar uma compra
* @author Gabriel Essenio e Weverton Bruno
* */
public interface PurchaseRepository {
    boolean existProduct(Long id);
    boolean allProductsExists(List<Long> ids);
    List<Product> getAllProductsIn(List<Long> idList);
    Order createPurchases(List<Purchase> purchases);
    void updateProductsQuantity(List<PurchaseDTO> purchaseArticles);
}
