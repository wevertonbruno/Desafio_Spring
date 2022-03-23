package br.com.meli.grupo1.desafio_spring.DTO;

import br.com.meli.grupo1.desafio_spring.entities.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ArticlesDTO {
    List<ArticleDTO> articlesDTO;
    public ArticlesDTO(List<Article> articles) {
        this.articlesDTO = articles
                .stream()
                .map(article -> new ArticleDTO(article.getProductId(), article.getName(), article.getQuantity())).collect(Collectors.toList());
    }

}
