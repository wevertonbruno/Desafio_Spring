package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.ArticlesDTO;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.repositories.GetAllArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetArticlesService {
    @Autowired
    private GetAllArticlesRepository products;

    public ArticlesDTO findArticles (String category, Boolean freeShipping, String productName, String brandName, Integer typeOrder) {

        List<Product> productsList = products.getAll();
//        List<Product>productsList = new ArrayList<>();
//        productsList = productsListRepo;

        if (category != null && productsList != null)
            productsList = productsList
                    .stream()
                    .filter(article -> article.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());


        if (freeShipping != null && productsList != null)
            productsList = productsList
                    .stream()
                    .filter(article -> article.getFreeShipping() && freeShipping)
                    .collect(Collectors.toList());


        if (productName != null && productsList != null)
            productsList = productsList
                    .stream()
                    .filter(article -> article.getName().equalsIgnoreCase(productName))
                    .collect(Collectors.toList());


        if (brandName != null && productsList != null)
            productsList = productsList
                    .stream()
                    .filter(article -> article.getBrand().equalsIgnoreCase(brandName))
                    .collect(Collectors.toList());


        if (typeOrder != null && productsList != null)
            switch (typeOrder) {
                case 0:
                    productsList = productsList
                            .stream()
                            .sorted((a, b) -> a.getName().compareTo(b.getName()))
                            .collect(Collectors.toList());
                    break;
                case 1:
                    productsList = productsList
                            .stream()
                            .sorted((a, b) -> b.getName().compareTo(a.getName()))
                            .collect(Collectors.toList());
                    break;
                case 2:
                    System.out.println("ordenacao decrescente de preco");
                    productsList = productsList
                            .stream()
                            .sorted((a, b) -> b.getPrice().compareTo(a.getPrice()))
                            .collect(Collectors.toList());
                    break;
                case 3:
                    System.out.println("ordenacao crescente de preco");
                    productsList = productsList
                            .stream()
                            .sorted((a, b) -> a.getPrice().compareTo(b.getPrice()))
                            .collect(Collectors.toList());
                    break;
            }
            try {
                return ArticlesDTO.convertToDTO(productsList);
            } catch (NullPointerException e) {
                //tratar desta exception
            }

        return new ArticlesDTO();

    }
}
