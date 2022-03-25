package br.com.meli.grupo1.desafio_spring.DTO;


import br.com.meli.grupo1.desafio_spring.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Rogério e Jeferson
 * por agrupar os produtos que são retornados na rota de busca de produtos
 */
@Data
@AllArgsConstructor
public class ArticlesDTO {
    private List<ArticleDTO> articlesDTO;

    public ArticlesDTO() {
        this.articlesDTO = new ArrayList<>();
    }
    /**
     * @author Rogério e Jeferson
     * esta função faz conversão das entidades do reponsitorio para os DTOS que serão enviados
     */
    public static ArticlesDTO convertToDTO(List<Product> products) throws NullPointerException {
        return new ArticlesDTO(products.stream()
                .map(article -> new ArticleDTO(article.getProductId(), article.getName(), article.getQuantity()))
                .collect(Collectors.toList()));
    }
}
