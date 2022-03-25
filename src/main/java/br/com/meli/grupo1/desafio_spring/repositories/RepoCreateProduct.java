package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.entities.Product;

import java.util.List;
/*
 * Interface do Repositorio de Product com os metodos auxiliares para realizar o cadastro dos produtos
 * @author Ederson Rodrigues e Nayara Coca
 * */
public interface RepoCreateProduct {
    List<Product> create (List<Product> products);

}
