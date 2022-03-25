package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.purchases.*;
import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.entities.Purchase;
import br.com.meli.grupo1.desafio_spring.exceptions.EmptyPurchaseException;
import br.com.meli.grupo1.desafio_spring.exceptions.UnregisteredProductException;
import br.com.meli.grupo1.desafio_spring.repositories.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        /* Gera as purchases */
        List<Purchase> purchases = products.stream().map(p -> new Purchase(quantidades.get(p.getProductId()), p)).collect(Collectors.toList());

        /* Gera uma Order com base nas purchases */
        Order order = purchaseRepository.createPurchases(purchases);

        /* Gera retorno para o usuario com DTO */
        return createPresentation(order);
    }

    private void verifyEmptyArticles(List<PurchaseDTO> articles){
        if(articles.size() == 0){
            throw new EmptyPurchaseException("Nao é possível realizar compras sem produtos");
        }
    }

    private void verifyProducts(List<Long> productsIdList){
        boolean allProductsExists = purchaseRepository.allProductsExists(productsIdList);

        if (!allProductsExists) {
            throw new UnregisteredProductException("Produto solicitado nao cadastrado");
        }
    }

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
