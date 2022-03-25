    package br.com.meli.grupo1.desafio_spring.services;

import br.com.meli.grupo1.desafio_spring.DTO.ArticlesDTO;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import br.com.meli.grupo1.desafio_spring.repositories.GetAllProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Rogério e Jefferson
 * Esta classe é responsável por fazer o tratamento das requisições do busca de produtos
 */
@Service
public class GetProductsService {

    /**
     * @author Rogério e Jefferson
     * Faz injeção de reponsitório de produtos
     */
    @Autowired
    private GetAllProductsRepository products;

    /**
     * @author Rogério e Jefferson
     * Este metodo faz leitura dos produtos existente e aplica sequenacialmente todos os filtros e ordenação enviados
     * na requisição
     */

    public ArticlesDTO findProducts(String category, Boolean freeShipping, String productName, String brandName, Integer typeOrder) {

        List<Product> productsList = products.getAll();

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

        if (productsList != null) {
            return ArticlesDTO.convertToDTO(productsList);
        } else {
            return new ArticlesDTO();
        }
    }
}
