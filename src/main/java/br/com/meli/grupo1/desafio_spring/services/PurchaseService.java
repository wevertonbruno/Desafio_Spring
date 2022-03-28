package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.purchases.*;
import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.entities.Purchase;
import br.com.meli.grupo1.desafio_spring.exceptions.EmptyPurchaseException;
import br.com.meli.grupo1.desafio_spring.exceptions.QuantityIsNotEnough;
import br.com.meli.grupo1.desafio_spring.exceptions.UnregisteredProductException;
import br.com.meli.grupo1.desafio_spring.repositories.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementaçao da camada service para criaçao das regras de negocios
 * @author Weverton Bruno e Gabriel Essenio
 */

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    public ListOrderDTO purchaseOrder(PurchaseRequestDTO request){
        /* Verifica se a lista contem pelo menos 1 produto */
        verifyEmptyArticles(request.getArticlesPurchaseRequest());

        /* Gera lista de ids de produtos */
        List<Long> productsIdList = request.getArticlesPurchaseRequest().stream().map(p -> p.getProductId()).collect(Collectors.toList());

        /* Validar se todos os produtos existem */
        verifyProducts(productsIdList);

        /* Gera lista com quantidades para criar purchases */
        Map<Long, Integer> quantidades = request.getArticlesPurchaseRequest().stream().collect(Collectors.toMap(
                item -> item.getProductId(),
                item -> item.getQuantity()
        ));

        /* Pega as informacoes dos produtos do repo */
        List<Product> products = purchaseRepository.getAllProductsIn(productsIdList);

        /* Verifica se existem produtos suficientes*/
        verifyHasQuantityEnough(products, quantidades);

        /* Realiza a atualização das quantidades de produtos em estoque no repositório*/
        purchaseRepository.updateProductsQuantity(request.getArticlesPurchaseRequest());

        /* Gera as purchases */
        List<Purchase> purchases = products.stream().map(p -> new Purchase(quantidades.get(p.getProductId()), p)).collect(Collectors.toList());

        /* Gera uma Order com base nas purchases */
        Order order = purchaseRepository.createPurchases(purchases);

        /* Gera retorno para o usuario com DTO */
        return createPresentation(order);
    }
        /*Verifica se lista de articles esta vazia , e lança exceçao com mensagem caso esteja*/
    private void verifyEmptyArticles(List<PurchaseDTO> articles){
        if(articles.size() == 0){
            throw new EmptyPurchaseException("Nao é possível realizar compras sem produtos");
        }
    }
        /* Verifica se o produto esta cadastrado, caso nao estaja , lança exceçao com mensagem*/
    private void verifyProducts(List<Long> productsIdList){
        boolean allProductsExists = purchaseRepository.allProductsExists(productsIdList);

        if (!allProductsExists) {
            throw new UnregisteredProductException("Produto solicitado nao cadastrado");
        }
    }
    /* Verifica se exite a quantidade de produtos suficiente , lança exceçao com mensagem*/
    private void verifyHasQuantityEnough(List<Product> productsInStock, Map<Long, Integer> quantidades) {
        /* O Map quantidades mapeia o Id do produto com a quantidade comprada */
        for (Product product: productsInStock){
            if(product.getQuantity()< quantidades.get(product.getProductId())){
                throw new QuantityIsNotEnough("Não há quantidade suficiente de produtos para realizar a compra");
            }
        }
    }

    /*Mapeia os dados do produto e retorna lista de o article da solicitaçao de compra */
    private ListOrderDTO createPresentation(Order order){
        List<PurchaseArticleDTO> articleDTO = order.getPurchases().stream().map(purchase -> new PurchaseArticleDTO(
                purchase.getProduct().getProductId(),
                purchase.getProduct().getName(),
                purchase.getProduct().getCategory(),
                purchase.getProduct().getBrand(),
                purchase.getProduct().getPrice(),
                purchase.getQuantity(),
                purchase.getProduct().getFreeShipping(),
                purchase.getProduct().getPrestige()
        )).collect(Collectors.toList());

        OrderDTO orderDTO = new OrderDTO(order.getId(), articleDTO);

        return new ListOrderDTO(orderDTO);
    }
}
