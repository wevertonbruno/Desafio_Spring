package br.com.meli.grupo1.desafio_spring.repositories;

import br.com.meli.grupo1.desafio_spring.DTO.PurchaseRequestDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository {
    public boolean existProduct(Integer id);
}
