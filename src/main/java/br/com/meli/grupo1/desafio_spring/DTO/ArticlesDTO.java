package br.com.meli.grupo1.desafio_spring.DTO;

import br.com.meli.grupo1.desafio_spring.entities.Article;
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
}
