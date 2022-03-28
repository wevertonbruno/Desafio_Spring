package br.com.meli.grupo1.desafio_spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

/*
 * Entidade de Compra de Produto com atibutos Quantidade e Produto
 * Criaçao de constructor com anotaçao
 * @author Weverton Bruno e Gabriel Essenio
 */

public class Purchase {
    private Integer quantity;
    private Product product;

    @Override
    public String toString() {
        return "Purchase{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
