package br.com.meli.grupo1.desafio_spring.DTO;


import br.com.meli.grupo1.desafio_spring.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesDTO {
    List<ArticleDTO> articlesDTO;

    public static ArticlesDTO convertToDTO(List<Product> products) throws NullPointerException {
        return new ArticlesDTO(products.stream()
                .map(article -> new ArticleDTO(article.getProductId(), article.getName(), article.getQuantity()))
                .collect(Collectors.toList()));
    }
}
