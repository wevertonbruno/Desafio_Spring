package br.com.meli.grupo1.desafio_spring.repositories.impl;

import br.com.meli.grupo1.desafio_spring.DTO.purchases.PurchaseDTO;
import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.entities.Purchase;
import br.com.meli.grupo1.desafio_spring.repositories.PurchaseRepository;
import br.com.meli.grupo1.desafio_spring.repositories.RepoCreateProduct;
import br.com.meli.grupo1.desafio_spring.utils.JsonUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonProductRepository implements PurchaseRepository, RepoCreateProduct {
    List<Product> dados = new ArrayList<>();

    public JsonProductRepository() throws IOException {
        dados = JsonUtil.readAsList("file:src/main/resources/data/products.json", Product[].class);
    }

    @Override
    public boolean existProduct(Long id) {
        return dados.stream().anyMatch(p -> p.getProductId().equals(id));
    }

    @Override
    public boolean allProductsExists(List<Long> ids) {
        for(Long id: ids){
            if(!existProduct(id)){
                return false;
            }
        }

        return true;
    }

    private Product findById(Long id){
        return dados.stream().filter(p -> p.getProductId().equals(id)).findFirst().get();
    }

    @Override
    public Order createPurchases(List<PurchaseDTO> purchasesDTO) {
        List<Purchase> purchases = purchasesDTO.stream().map(p -> new Purchase(p.getQuantity(), findById(p.getProductId()))).collect(Collectors.toList());

        Order order = new Order(530, purchases);

        try {
            JsonUtil.saveAsFile("file:src/main/resources/data/orders.json", order);
            return order;
        }catch (IOException e){
            return null;
        }
    }

    @Override
    public List<Product> create(List<Product> products) {
        try {
            JsonUtil.saveAsFile("file:src/main/resources/data/products.json", products);
            dados = products;
            return products;
        }catch (IOException e){
            return null;
        }
    }
}
