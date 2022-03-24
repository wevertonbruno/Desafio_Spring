package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.entities.Product;

import java.util.List;

public interface RepoCreateProduct {
    List<Product> create (List<Product> products);

}
