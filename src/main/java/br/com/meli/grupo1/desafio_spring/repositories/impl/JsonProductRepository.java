package br.com.meli.grupo1.desafio_spring.repositories.impl;

import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.entities.Purchase;
import br.com.meli.grupo1.desafio_spring.exceptions.FailToSaveInStorage;
import br.com.meli.grupo1.desafio_spring.repositories.CartRepository;
import br.com.meli.grupo1.desafio_spring.repositories.GetAllProductsRepository;
import br.com.meli.grupo1.desafio_spring.repositories.PurchaseRepository;
import br.com.meli.grupo1.desafio_spring.repositories.RepoCreateProduct;
import br.com.meli.grupo1.desafio_spring.utils.JsonUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementacao do Repositorio Json para manipulacao dos dados
 * @author Weverton Bruno e Gabriel Essenio
 */

@Repository
public class JsonProductRepository implements PurchaseRepository, RepoCreateProduct, GetAllProductsRepository, CartRepository {
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

    /*
    * Verifica se todos os produtos requeridos existem no banco
    * */
    @Override
    public boolean allProductsExists(List<Long> ids) {
        for(Long id: ids){
            if(!existProduct(id)){
                return false;
            }
        }

        return true;
    }

    /*
    * Busca todos os produtos do banco pela lista de ids
    * */
    @Override
    public List<Product> getAllProductsIn(List<Long> idList) {
        return idList.stream().map(id -> findById(id)).collect(Collectors.toList());
    }

    /*
    * Faz a busca por um produto pelo id
    * */
    private Product findById(Long id){
        return products.stream().filter(p -> p.getProductId().equals(id)).findFirst().get();
    }

    /*
    * Gera o id da proxima compra com base na quantidade de compras existentes
    * */
    private Integer gerenatePurchaseId(){
            return orders.size() + 1;
    }

    /*
    * Recebe uma lista de produtos (produto + quantidade) e gera uma Compra
    * */
    @Override
    public Order createPurchases(List<Purchase> purchases) {
        /* Gerando ID da compra */
        Integer generatedId = gerenatePurchaseId();

        /* Criando a compra*/
        Order order = new Order(generatedId, purchases);

        /* Atualiza em memoria */
        orders.add(order);

        /* Salvando a compra em um arquivo JSON */
        try {
            JsonUtil.saveAsFile("file:src/main/resources/data/orders.json", orders);
            return order;
        }catch (IOException e){
            throw new FailToSaveInStorage("Nao foi possivel salvar os dados solicitados");
        }
    }

    /*
    * Salva uma lista de produtos no arquivo products.json
    * */
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

    /*
    * Retorna a lista com todos os produtos cadastrados
    * */
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public List<Order> getAllOrder() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
        try {
            JsonUtil.saveAsFile("file:src/main/resources/data/orders.json", orders);
        }catch (IOException e){
            System.out.println("Falha ao persistir dados de order");
        }
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        try {
            JsonUtil.saveAsFile("file:src/main/resources/data/products.json", products);
        }catch (IOException e){
            System.out.println("Falha ao persistir dados de produtos");
        }
    }
}
