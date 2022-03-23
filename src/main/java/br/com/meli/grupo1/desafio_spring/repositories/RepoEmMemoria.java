package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.DTO.ProductCreateResponseDTO;
import br.com.meli.grupo1.desafio_spring.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepoEmMemoria implements RepoCreateProduct{

    @Override
    public ProductCreateResponseDTO create(List<Product> products) {
        return null;
    }
}
