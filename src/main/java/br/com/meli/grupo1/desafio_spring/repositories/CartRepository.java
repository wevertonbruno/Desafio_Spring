package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.entities.Order;

import java.util.List;

public interface CartRepository {
    List<Order> getAllOrder();
}
