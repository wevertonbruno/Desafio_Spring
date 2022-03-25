package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.purchases.PurchaseArticleDTO;
import br.com.meli.grupo1.desafio_spring.DTO.purchases.ListOrderDTO;
import br.com.meli.grupo1.desafio_spring.DTO.purchases.OrderDTO;
import br.com.meli.grupo1.desafio_spring.DTO.purchases.PurchaseRequestDTO;
import br.com.meli.grupo1.desafio_spring.entities.Order;
import br.com.meli.grupo1.desafio_spring.entities.Product;
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
        if(request.getArticlesPurchaseRequest().size() == 0){
            throw new EmptyPurchaseException("Nao é possível realizar compras sem produtos");
        }

        /* Gera lista de ids de produtos */
        List<Long> productsIdList = request.getArticlesPurchaseRequest().stream().map(p -> p.getProductId()).collect(Collectors.toList());

        /* Validar se todos os produtos existem */
        boolean allProductsExists = purchaseRepository.allProductsExists(productsIdList);

        if (!allProductsExists) {
            throw new UnregisteredProductException("Produto solicitado nao cadastrado");
        }

        /* Gera uma Order com base nas purchases */
        Order order = purchaseRepository.createPurchases(request.getArticlesPurchaseRequest());

        /* Gera retorno para o usuario com DTO */
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

        OrderDTO orderDTO = new OrderDTO(order.getId(), articleDTO );

        return new ListOrderDTO(orderDTO);
    }
}
