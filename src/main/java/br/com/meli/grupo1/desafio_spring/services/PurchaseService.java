package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.purchases.ArticleDTO;
import br.com.meli.grupo1.desafio_spring.DTO.purchases.ListOrderDTO;
import br.com.meli.grupo1.desafio_spring.DTO.purchases.OrderDTO;
import br.com.meli.grupo1.desafio_spring.DTO.purchases.PurchaseRequestDTO;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.exceptions.UnregisteredProductException;
import br.com.meli.grupo1.desafio_spring.repositories.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
        //Validar se o produto existe
        boolean verifyProduct = request.getArticlesPurchaseRequest().stream()
                .filter(p -> !purchaseRepository.existProduct(p.getProductId()))
                .findAny()
                .isEmpty();

        if (verifyProduct) {
            throw new UnregisteredProductException("Produto solicitado nao cadastrado ");
        }

        //Gera lista de ids de produtos
        List<Integer> idList = request.getArticlesPurchaseRequest().stream().map(p -> p.getProductId()).collect(Collectors.toList());

        Map<Integer, Integer> quantidades = request.getArticlesPurchaseRequest()
                .stream()
                .collect(Collectors.toMap(item -> item.getProductId(), item -> item.getQuantity()));

        // Busca todos os produtos pela lista de IDs
        List<Product> products = purchaseRepository.findProductsIn(idList);

        BigDecimal total = BigDecimal.ZERO;

        for(Product product : products){
            Integer quantidade = quantidades.get(product.getProductId());
            total = total.add(product.getPrice().multiply(BigDecimal.valueOf(quantidade)));
        }


        List<ArticleDTO> articleDTO = products.stream().map(item -> new ArticleDTO(
                item.getProductId(),
                item.getName(),
                item.getCategory(),
                item.getBrand(),
                item.getPrice(),
                item.getQuantity(),
                item.getFreeShipping(),
                item.getPrestige()
        )).collect(Collectors.toList());

        //Nao soube o que colocar nesse ID
        OrderDTO orderDTO = new OrderDTO( 1, articleDTO, total );

        return new ListOrderDTO(orderDTO);
    }
}
