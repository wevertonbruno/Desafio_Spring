package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Rogério e Jeferson
 * Esta interface prevê a existencia de uma função que retorne todos os produtos do reponsitório
 * ela foi criada para posssbilitar a implementação do service de busca de produtos antes mesmo
 * do repositorio tivesse sido criado.
 */
public interface GetAllProductsRepository {
    public List<Product> getAll();
}
