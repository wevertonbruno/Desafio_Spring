package br.com.meli.grupo1.desafio_spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Usado para dar resposta apos cadastrar um produto
 * @author Ederson Rodrigues e Nayara Coca
 */

import java.util.List;

/**
 * Usado para responder ao usuario apos criar a lista de produtos
 * @author Ederson Rodrigues e Nayara Coca
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateResponseDTO {
    List<ProductDTO> articlesDTO;
}
