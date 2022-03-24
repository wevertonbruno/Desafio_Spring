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
//    public Product(Long productId, String name, String category, String brand, Double price, Integer quantity,
//                   boolean freeShipping, String prestige) {
    public static List<Product> productsList = new ArrayList<>();

    static {
        productsList.addAll(Arrays.asList(
                new Product(1L, "Serra de Bancada","Ferramentas", "FORTGPRO", BigDecimal.valueOf(1.800), 5, true, "****"),
                new Product(2L, "Furadeira","Ferramentas", "Black & Decker", BigDecimal.valueOf(500), 7, true, "****"),
                new Product(2L, "Soldadora","Ferramentas", "Black & Decker", BigDecimal.valueOf(350.0), 7, true, "***"),
                new Product(3L, "Chuteira","Esportes", "Black & Decker", BigDecimal.valueOf(235), 10, true, "*****"),
                new Product(4L, "Mini Cama elastica","Esportes", "Adidas", BigDecimal.valueOf(183), 6, true, "*****"),
                new Product(5L, "Camiseta","Esportes", "Starboard", BigDecimal.valueOf(80), 4, true, "***")
        ));
    }

    public ArticlesDTO findArticles (String category, Boolean freeShipping, String productName, String brandName, Integer typeOrder) {
//        List<Product> productsList = products.getAll();
        if (category != null && productsList != null)
            productsList = productsList
                    .stream()
                    .filter(article -> article.getCategory().equals(category))
                    .collect(Collectors.toList());
        if (freeShipping != null && productsList != null)
            productsList = productsList
                    .stream()
                    .filter(article -> article.getFreeShipping() && freeShipping)
                    .collect(Collectors.toList());
        if (productName != null && productsList != null)
            productsList = productsList
                    .stream()
                    .filter(article -> article.getBrand().equals(productName))
                    .collect(Collectors.toList());
        if (brandName != null && productsList != null)
            productsList = productsList
                    .stream()
                    .filter(article -> article.getBrand().equals(brandName))
                    .collect(Collectors.toList());
        if (typeOrder != null && productsList != null)
            switch (typeOrder){
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
                    productsList = productsList
                            .stream()
                            .sorted((a, b) -> b.getPrice().compareTo(a.getPrice()))
                            .collect(Collectors.toList());
                    break;
                case 3:
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
