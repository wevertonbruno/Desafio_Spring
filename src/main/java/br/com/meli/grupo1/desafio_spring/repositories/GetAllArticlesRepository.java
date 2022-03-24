package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetAllArticlesRepository {
    public List<Product> getAll();
}
