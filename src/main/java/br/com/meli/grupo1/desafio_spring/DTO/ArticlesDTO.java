package br.com.meli.grupo1.desafio_spring.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesDTO {
    List<ArticleDTO> articlesDTO;
}
