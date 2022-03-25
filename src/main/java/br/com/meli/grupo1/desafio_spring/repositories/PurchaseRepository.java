package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.DTO.purchases.PurchaseDTO;
import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.entities.Purchase;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PurchaseRepository {
    boolean existProduct(Long id);
    boolean allProductsExists(List<Long> ids);
    List<Product> getAllProductsIn(List<Long> idList);
    Order createPurchases(List<Purchase> purchases);
}
