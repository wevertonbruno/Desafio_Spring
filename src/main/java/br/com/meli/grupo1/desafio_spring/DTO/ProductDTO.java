package br.com.meli.grupo1.desafio_spring.DTO;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private Long productId;
    private String name;
    private Integer quantity;

}
