package br.com.meli.grupo1.desafio_spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    private Integer quantity;
    private Product product;

    public BigDecimal getSubTotal(){
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "quantity=" + quantity +
                ", product=" + product +
                ", subTotal=" + getSubTotal() +
                '}';
    }
}
