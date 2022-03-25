package br.com.meli.grupo1.desafio_spring.DTO;


import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
/**
 * Usado para da o terno ao usuario apos o cadastro
 * @author Ederson Rodrigues e Nayara Coca
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private Long productId;
    private String name;
    private Integer quantity;

}
