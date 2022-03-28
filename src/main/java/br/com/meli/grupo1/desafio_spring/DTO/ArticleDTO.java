package br.com.meli.grupo1.desafio_spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Rogério e Jeferson
 * esta classe é reponsável por formatar os dados de produtos que a rota de busca de produtos retorna
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long productId;
    private String name;
    private Integer quantity;
}
