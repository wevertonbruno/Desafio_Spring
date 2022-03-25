package br.com.meli.grupo1.desafio_spring.repositories.impl;

import br.com.meli.grupo1.desafio_spring.DTO.purchases.PurchaseDTO;
import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.entities.Purchase;
import br.com.meli.grupo1.desafio_spring.exceptions.FailToSaveInStorage;
import br.com.meli.grupo1.desafio_spring.repositories.GetAllArticlesRepository;
import br.com.meli.grupo1.desafio_spring.repositories.PurchaseRepository;
import br.com.meli.grupo1.desafio_spring.repositories.RepoCreateProduct;
import br.com.meli.grupo1.desafio_spring.utils.JsonUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonProductRepository implements PurchaseRepository, RepoCreateProduct, GetAllArticlesRepository {
    List<Product> products;
    List<Order> orders;

    public JsonProductRepository() throws IOException {
        products = JsonUtil.readAsList("file:src/main/resources/data/products.json", Product[].class);
        orders = JsonUtil.readAsList("file:src/main/resources/data/orders.json", Order[].class);
    }

    @Override
    public boolean existProduct(Long id) {
        return products.stream().anyMatch(p -> p.getProductId().equals(id));
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

    @Override
    public List<Product> getAllProductsIn(List<Long> idList) {
        return idList.stream().map(id -> findById(id)).collect(Collectors.toList());
    }

    private Product findById(Long id){
        return products.stream().filter(p -> p.getProductId().equals(id)).findFirst().get();
    }

    private Integer gerenatePurchaseId(){
            return orders.size() + 1;
    }

    @Override
    public Order createPurchases(List<PurchaseDTO> purchasesDTO) {
        /* Mapeando DTO para lista de purchases TODO mover esse map para a camada de servico */
        List<Purchase> purchases = purchasesDTO.stream().map(p -> new Purchase(p.getQuantity(), findById(p.getProductId()))).collect(Collectors.toList());

        /* Gerando ID da compra */
        Integer generatedId = gerenatePurchaseId();

        /* Criando a compra*/
        Order order = new Order(generatedId, purchases);
        orders.add(order);

        /* Salvando a compra em um arquivo JSON */
        try {
            JsonUtil.saveAsFile("file:src/main/resources/data/orders.json", orders);
            return order;
        }catch (IOException e){
            throw new FailToSaveInStorage("Nao foi possivel salvar os dados solicitados");
        }
    }

    @Override
    public List<Product> create(List<Product> productsList) {
        try {
            JsonUtil.saveAsFile("file:src/main/resources/data/products.json", productsList);
            products = productsList;
            return products;
        }catch (IOException e){
            return null;
        }
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
