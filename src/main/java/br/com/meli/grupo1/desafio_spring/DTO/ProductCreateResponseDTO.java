package br.com.meli.grupo1.desafio_spring.DTO;

import br.com.meli.grupo1.desafio_spring.entities.Product;

import java.util.List;

public class ProductCreateResponseDTO {
    public static ProductCreateResponseDTO fromProducts(List<Product> products){
        return new ProductCreateResponseDTO();
    }
}
